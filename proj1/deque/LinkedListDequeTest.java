package deque;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {


        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,",
                null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,",
                null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }

    @Test
    public void timeLLDequeConstruction() {
        LinkedListDeque<Integer> instances = new LinkedListDeque<>();
        LinkedListDeque<Double> times = new LinkedListDeque<>();
        LinkedListDeque<Integer> opCounts = new LinkedListDeque<>();
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
        LinkedListDeque<Integer> aList = new LinkedListDeque<>();
        for (int i = 0; i < count; i++) {
            aList.addLast(i);
        }
    }

    private static void printTimingTable(LinkedListDeque<Integer> Ns, LinkedListDeque<Double> times,
                                         LinkedListDeque<Integer> opCounts) {
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
        LinkedListDeque<Integer> linkedListDeque1 = new LinkedListDeque<>();
        LinkedListDeque<Integer> linkedListDeque2 = new LinkedListDeque<>();
        int count = 3;
        for (int i = 0; i < count; i++) {
            linkedListDeque1.addLast(i);
            linkedListDeque2.addFirst(i);
        }
        for (int i = 0; i < count; i++) {
            assertEquals(new Integer(i), linkedListDeque1.removeFirst());
            assertEquals(new Integer(i), linkedListDeque2.removeLast());
        }
    }
    @Test
    public void randomizedTestWithLLDequeAndArrayDeque() {
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int count = 10000;
        for (int i = 0; i < count; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            switch(operationNumber) {
                case 0:
                    // addLast
                    int randVal = StdRandom.uniform(0, 100);
                    linkedListDeque.addLast(randVal);
                    arrayDeque.addLast(randVal);
                    break;
                case 1:
                    // size
                    int size = linkedListDeque.size();
                    int buggyAListSize = arrayDeque.size();
                    assertEquals(size, buggyAListSize);
                    break;
                case 2:
                    // remove
                    assertEquals(linkedListDeque.size(), arrayDeque.size());
                    if (linkedListDeque.size() > 0) {
                        Integer lastItem = linkedListDeque.removeFirst();
                        Integer buggyAListLast = arrayDeque.removeFirst();
                        assertEquals(lastItem, buggyAListLast);
                    }
                    break;
                case 3:
                    // removeLast
                    assertEquals(linkedListDeque.size(), arrayDeque.size());
                    if(linkedListDeque.size() > 0) {
                        Integer lastItem = linkedListDeque.removeLast();
                        Integer buggyLastItem = arrayDeque.removeLast();
                        assertEquals(lastItem, buggyLastItem);
                    }
                    break;
                case 4:
                    // addFirst
                    int randValue = StdRandom.uniform(0, 100);
                    linkedListDeque.addFirst(randValue);
                    arrayDeque.addFirst(randValue);
                    break;
                default:
                    /*ignore*/
            }
        }
    }

    @Test
    public void testEquals() {
        LinkedListDeque<Integer> firstDeque = new LinkedListDeque<>();
        LinkedListDeque<Integer> secondDeque = new LinkedListDeque<>();
        assertTrue(firstDeque.equals(secondDeque));
        for (int i = 0; i < 100; i++) {
            firstDeque.addLast(i);
            secondDeque.addLast(i);
        }
        assertTrue(firstDeque.equals(secondDeque));
        firstDeque.addLast(100);
        secondDeque.addLast(99);
        assertFalse(firstDeque.equals(secondDeque));

        ArrayDeque<String> stringArrayDeque = new ArrayDeque<>();
        assertFalse(firstDeque.equals(stringArrayDeque));
    }

    @Test
    public void testEqualsBetweenArrayDequeAndLinkedListDeque() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        LinkedListDeque<Integer> linkedListDeque = new LinkedListDeque<>();
        assertTrue(arrayDeque.equals(linkedListDeque));
        for (int i = 0; i < 100; i++) {
            arrayDeque.addLast(i);
            linkedListDeque.addLast(i);
        }
        assertTrue(arrayDeque.equals(linkedListDeque));
    }
}
