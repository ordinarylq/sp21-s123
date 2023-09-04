package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{

    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> comparator) {
        super();
        this.comparator = comparator;
    }

    public T max() {
        return compare(this.comparator);
    }

    public T max(Comparator<T> c) {
        return compare(c);
    }

    private T compare(Comparator<T> c) {
        int size = size();
        T maxItem = get(0);
        for (int i = 1; i < size; i++) {
            T t = get(i);
            if (c.compare(maxItem, t) < 0) {
                maxItem = t;
            }
        }
        return maxItem;
    }

}
