package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimes2() {
        IntList list = IntList.of(1, 2, 3, 4, 5);
        boolean changed = IntListExercises.squarePrimes(list);
        assertEquals("1 -> 4 -> 9 -> 4 -> 25", list.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimes3() {
        IntList list = IntList.of(-1, 5, 6, 7, 10);
        boolean changed = IntListExercises.squarePrimes(list);
        assertEquals("-1 -> 25 -> 6 -> 49 -> 10", list.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimes4() {
        IntList list = IntList.of(4, 6, 8, 9, 10);
        boolean changed = IntListExercises.squarePrimes(list);
        assertEquals("4 -> 6 -> 8 -> 9 -> 10", list.toString());
        assertFalse(changed);
    }
}
