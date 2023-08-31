package deque;

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

}
