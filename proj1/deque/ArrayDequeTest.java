package deque;

import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @ClassName: ArrayDequeTest
 * @Author: LiQi
 * @Date: 2023-08-31 14:44
 * @Version: V1.0
 * @Description:
 */
public class ArrayDequeTest {

    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        assertTrue("A newly initialized ArrayDeque should be empty.", arrayDeque.isEmpty());

        arrayDeque.addFirst("front");

        assertEquals(1, arrayDeque.size());
        assertFalse("ArrayDeque should now contain 1 element", arrayDeque.isEmpty());

        arrayDeque.addLast("middle");
        assertEquals(2, arrayDeque.size());

        arrayDeque.addLast("back");
        assertEquals(3, arrayDeque.size());

        System.out.println("Printing out deque: ");
        arrayDeque.printDeque();
    }

    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        assertTrue("A newly initialized ArrayDeque should be empty.",
                arrayDeque.isEmpty());

        arrayDeque.addFirst(30);
        assertFalse("ArrayDeque should now contain 1 element.",
                arrayDeque.isEmpty());

        arrayDeque.removeFirst();
        assertTrue("ArrayDeque should be empty after removal the only item."
                , arrayDeque.isEmpty());
    }

    @Test
    public void removeEmptyTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst(3);

        arrayDeque.removeLast();
        arrayDeque.removeFirst();
        arrayDeque.removeLast();
        arrayDeque.removeFirst();
        int size = arrayDeque.size();
        assertEquals("The arrayDeque should be empty after removal the only item.", 0, size);
    }

    @Test
    public void emptyNullReturnTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        assertNull("Should return null when removeFirst is called on an empty ArrayDeque",
                arrayDeque.removeFirst());

        assertNull("Should return null when removeLast is called on an empty ArrayDeque",
                arrayDeque.removeLast());
    }

    @Test
    public void bigArrayDequeTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            arrayDeque.addLast(i);
        }
        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value.", i, (double) arrayDeque.removeFirst(), 0.0);
        }

        for (int i = 999999; i > 500000 ; i--) {
            assertEquals("Should have the same value.", i, (double) arrayDeque.removeLast(), 0.0);
        }
    }

    @Test
    public void addAndGetDequeTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        Integer expected = 1;
        arrayDeque.addFirst(1);
        Integer actual = arrayDeque.get(0);
        assertEquals("Should have the same value", expected, actual);
    }

    @Test
    public void timeAListConstruction() {
        ArrayDeque<Integer> instances = new ArrayDeque<>();
        ArrayDeque<Double> times = new ArrayDeque<>();
        ArrayDeque<Integer> opCounts = new ArrayDeque<>();
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
        ArrayDeque<Integer> aList = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            aList.addLast(i);
        }
    }

    private static void printTimingTable(ArrayDeque<Integer> Ns, ArrayDeque<Double> times, ArrayDeque<Integer> opCounts) {
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

    @Test
    public void testThreeAddThreeRemove() {
        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        ArrayDeque<Integer> arrayDeque2 = new ArrayDeque<>();
        int count = 3;
        for (int i = 0; i < count; i++) {
            arrayDeque1.addLast(i);
            arrayDeque2.addFirst(i);
        }
        for (int i = 0; i < count; i++) {
            assertEquals(new Integer(i), arrayDeque1.removeFirst());
            assertEquals(new Integer(i), arrayDeque2.removeLast());
        }
    }

    @Test
    public void testEquals() {
        ArrayDeque<Integer> firstArrayDeque = new ArrayDeque<>();
        ArrayDeque<Integer> secondArrayDeque = new ArrayDeque<>();
        assertTrue(firstArrayDeque.equals(secondArrayDeque));
        for (int i = 0; i < 100; i++) {
            firstArrayDeque.addLast(i);
            secondArrayDeque.addLast(i);
        }
        assertTrue(firstArrayDeque.equals(secondArrayDeque));
        firstArrayDeque.addLast(100);
        secondArrayDeque.addLast(99);
        assertFalse(firstArrayDeque.equals(secondArrayDeque));

        ArrayDeque<String> stringArrayDeque = new ArrayDeque<>();
        assertFalse(firstArrayDeque.equals(stringArrayDeque));
    }
}
