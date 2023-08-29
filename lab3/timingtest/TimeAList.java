package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> instances = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int size = 1000;
        while(size <= 1024000) {
            instances.addLast(size);
            opCounts.addLast(size);

            Stopwatch stopwatch = new Stopwatch();
            addToAList(size);
            double elapsedTimeInSeconds = stopwatch.elapsedTime();

            times.addLast(elapsedTimeInSeconds);
            size *= 2;
        }
        printTimingTable(instances, times, opCounts);
    }

    private static void addToAList(int count) {
        AList<Integer> aList = new AList<>();
        for (int i = 0; i < count; i++) {
            aList.addLast(i);
        }
    }
}
