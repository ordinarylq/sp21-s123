package deque;

/**
 * Specs of doubly ended queue aka Deque.
 * @Author: LiQi
 * @Date: 2023-08-31 10:23
 * @Version: V1.0
 */
public interface Deque<T> {
    /**
     * Add an item to the head of the deque.
     * @param item the Item to be added
     */
    void addFirst(T item);

    /**
     * Add an item to the tail of the deque.
     * @param item the Item to be added
     */
    void addLast(T item);

    /**
     * Remove the first item of the deque.
     * @return T the removed item
     */
    T removeFirst();

    /**
     * Remove the last item of the deque.
     * @return T the removed item
     */
    T removeLast();

    /**
     * Get the specific item at index position with iteration.
     * @param index the index starting from 0
     * @return T the specific item
     */
    T get(int index);

    /**
     * Check if the deque is empty
     * @return boolean true-empty false-not empty
     */
    default boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Get the size of the deque.
     * @return int the size
     */
    int size();

    /**
     * Print out deque to Standard output.
     */
    void printDeque();

}
