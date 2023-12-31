package deque;

import java.util.Iterator;

/**
 * @ClassName: LinkedListDeque
 * @Author: LiQi
 * @Date: 2023-08-31 9:28
 * @Version: V1.0
 * @Description:
 */
public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    /**
     * Internal node for a doubly linked list.
     */
    private static class Node<T> {
        private T item;
        private Node<T> prev;
        private Node<T> next;

        Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> sentinel;
    private Integer size;

    public LinkedListDeque() {
        this.sentinel = new Node<T>(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> node = new Node<>(item, this.sentinel, this.sentinel.next);
        this.sentinel.next = node;
        node.next.prev = node;

        this.size += 1;
    }

    @Override
    public void addLast(T item) {
        Node<T> node = new Node<>(item, this.sentinel.prev, this.sentinel);
        this.sentinel.prev = node;
        node.prev.next = node;

        this.size += 1;
    }

    @Override
    public T removeFirst() {
        if (this.size ==  0) {
            return null;
        }
        Node<T> node = this.sentinel.next;
        this.sentinel.next = node.next;
        node.next.prev = this.sentinel;
        this.size -= 1;

        return node.item;
    }

    @Override
    public T removeLast() {
        if (this.size == 0) {
            return null;
        }
        Node<T> node = this.sentinel.prev;
        node.prev.next = this.sentinel;
        this.sentinel.prev = node.prev;
        this.size -= 1;

        return node.item;
    }

    @Override
    public T get(int index) {
        Node<T> target = this.sentinel;

        Node<T> current = this.sentinel;
        for (int i = 0; i < this.size; i++) {
            current = current.next;
            if (i == index) {
                target = current;
            }
        }

        return target.item;
    }

    /**
     * Get the specific item at index position with recursion.
     * @param index the index starting from 0
     * @return T the specific item
     */
    public T getRecursive(int index) {
        return getRecursiveInternal(this.sentinel.next, 0, index);
    }

    /**
     * Recursively get the targetIndex-th item of the deque.
     * @param node first node of the deque
     * @param currentIndex current index
     * @param targetIndex target index
     * @return T value of i-th item of the deque
     */
    private T getRecursiveInternal(Node<T> node, int currentIndex, int targetIndex) {
        if (currentIndex == targetIndex) {
            return node.item;
        }
        if (node.next == this.sentinel) {
            return null;
        }
        return getRecursiveInternal(node.next, currentIndex + 1, targetIndex);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;
            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                return get(current++);
            }
        };
    }

    @Override
    public void printDeque() {
        Node<T> current = this.sentinel;
        for (int i = 0; i < this.size; i++) {
            current = current.next;
            System.out.print(current.item);
            if (i < this.size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Deque)) {
            return false;
        }
        Deque<Object> secondDeque = (Deque<Object>) obj;
        int firstDequeSize = size();
        if (firstDequeSize != secondDeque.size()) {
            return false;
        }
        for (int i = 0; i < firstDequeSize; i++) {
            if (!get(i).equals(secondDeque.get(i))) {
                return false;
            }
        }
        return true;
    }
}
