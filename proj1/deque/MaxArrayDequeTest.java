package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {

    @Test
    public void testMaxInteger() {
        MaxArrayDeque<Integer> maxArrayDeque = new MaxArrayDeque<>(getIntegerComparator());
        for (int i = 0; i < 100; i++) {
            maxArrayDeque.addLast(i);
        }
        assertEquals(new Integer(99), maxArrayDeque.max());
    }

    @Test
    public void testMaxString() {
        MaxArrayDeque<String> maxArrayDeque = new MaxArrayDeque<>(getStringComparator());
        for (char i = 'a'; i <= 'z'; i++) {
            maxArrayDeque.addLast(i + "");
        }
        assertEquals("z", maxArrayDeque.max());
    }

    @Test
    public void testMinIntegerWithComparator() {
        MaxArrayDeque<Integer> maxArrayDeque = new MaxArrayDeque<>(getIntegerComparator());
        for (int i = 0; i < 100; i++) {
            maxArrayDeque.addLast(i);
        }
        assertEquals(new Integer(0), maxArrayDeque.max(getMinIntegerComparator()));
    }

    @Test
    public void testMinStringWithComparator() {
        MaxArrayDeque<String> maxArrayDeque = new MaxArrayDeque<>(getStringComparator());
        for (char i = 'a'; i <= 'z'; i++) {
            maxArrayDeque.addLast(i + "");
        }
        assertEquals("a", maxArrayDeque.max(getMinStringComparator()));
    }

    private Comparator<Integer> getIntegerComparator() {
        return Integer::compareTo;
    }
    private Comparator<String> getStringComparator() {
        return String::compareTo;
    }

    private Comparator<Integer> getMinIntegerComparator() {
        return (first, second) -> -first.compareTo(second);
    }

    private Comparator<String> getMinStringComparator() {
        return (first, second) -> -first.compareTo(second);
    }

}
