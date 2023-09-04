package deque;

import java.util.Iterator;
import java.util.Objects;

/**
 * @ClassName: ArrayDeque
 * @Author: LiQi
 * @Date: 2023-08-31 13:01
 * @Version: V1.0
 * @Description:
 */
public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private T[] items;

    private Integer head;

    private Integer tail;

    public static final Integer INITIAL_SIZE = 8;

    public static final Integer RESIZE_FACTOR = 2;

    public ArrayDeque() {
        this.items = (T[]) new Object[INITIAL_SIZE];
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public void addFirst(T item) {
        if (size() == this.items.length - 1) {
            resize(this.items.length * RESIZE_FACTOR);
        }
        this.head = (this.head - 1 + this.items.length) % this.items.length;
        this.items[this.head] = item;
    }

    @Override
    public void addLast(T item) {
        if (size() == this.items.length - 1) {
            resize(this.items.length * RESIZE_FACTOR);
        }
        this.items[this.tail] = item;
        this.tail = (this.tail + 1) % this.items.length;
    }

    @Override
    public T removeFirst() {
        if (Objects.equals(this.head,this.tail)) {
            return null;
        }
        // TODO: 2023-8-31 Need to consider downsizing
        int length = this.items.length;
        T firstItem = this.items[this.head];
        this.items[this.head] = null;
        this.head = (this.head + 1) % length;

        return firstItem;
    }

    @Override
    public T removeLast() {
        if (Objects.equals(this.head,this.tail)) {
            return null;
        }
        // TODO: 2023-8-31 Need to consider downsizing
        int length = this.items.length;
        int targetIndex = (this.tail - 1 + length) % length;
        T lastItem = this.items[targetIndex];
        this.items[targetIndex] = null;
        this.tail = targetIndex;

        return lastItem;
    }

    /**
     * Resize the array.
     * @param capacity the length of the array to grow to
     */
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        int front = this.head;
        int size = size();
        int oldArrayLength = this.items.length;
        for (int i = 0; i < size; i++) {
            int nextElementIndex = (front + i) % oldArrayLength;
            newArray[i] = this.items[nextElementIndex];
        }
        this.items = newArray;
        this.head = 0;
        this.tail = size;
    }

    /**
     * Downsize the array.
     */
    private void downsize() {
        
    }

    @Override
    public T get(int index) {
        int targetIndex = (this.head + index) % this.items.length;
        return this.items[targetIndex];
    }

    @Override
    public int size() {
        return (this.tail - this.head + this.items.length) % this.items.length;
    }

    @Override
    public void printDeque() {
        int headIndex = this.head;
        int arrayLength = this.items.length;
        int arraySize = this.size();
        for (int i = 0; i < arraySize; i++) {
            int currentIndex = (headIndex + i) % arrayLength;
            System.out.print(this.items[currentIndex]);
            if (i < arraySize - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
