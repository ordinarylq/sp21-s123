package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.awt.image.LookupOp;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        AList<Integer> instances = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int size = 1000, opCnt = 10000;
        while(size <= 128000) {
            SLList<Integer> list = new SLList<>();
            multipleAddFirst(size, list);

            Stopwatch stopwatch = new Stopwatch();
            multipleGetLast(opCnt, list);
            double elapsedTime = stopwatch.elapsedTime();

            instances.addLast(size);
            times.addLast(elapsedTime);
            opCounts.addLast(opCnt);

            size *= 2;
        }
        printTimingTable(instances, times, opCounts);
    }

    private static void multipleAddFirst(int count, SLList<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.addFirst(i);
        }
    }

    private static void multipleGetLast(int count, SLList<Integer> list) {
        for (int i = 0; i < count; i++) {
            list.getLast();
        }
    }

}
