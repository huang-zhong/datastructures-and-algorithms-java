package com.hzzz.www.queue;

/**
 * Dequeue is a queue implemented of linked list.
 * It has two ends, front and rear, and supports adding and removing elements from both ends.
 * @param <T>
 */
public class Dequeue<T> implements Queue<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T item) {
            this.item = item;
        }
        Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Add an element to the end of the queue.
     * @param item the element to be added.
     */
    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    /**
     * Add an element to the front of the queue.
     * @param item the element to be added.
     */
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    /**
     * Add an element to the end of the queue.
     * @param item the element to be added.
     */
    public void addLast(T item) {
        add(item);
    }

    /**
     * Add an element at the specified index.
     * @param index the index to add the elenment at.
     * @param item the element to be added.
     */
    public void addAt(int index, T item) {
        checkIndex(index);
        Node<T> newNode = new Node<>(item);
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.prev = current;
        newNode.next = current.next;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Remove an element from the front of the queue.
     * @return the element removed.
     */
    @Override
    public T remove() {
        if (head == null) {
            throw new RuntimeException("The queue is empty");
        }
        T result = head.item;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return result;
    }

    /**
     * Remove an element from the front of the queue.
     */
    public void removeFirst() {
        remove();
    }

    /**
     * Remove an element from the end of the queue.
     */
    public void removeLast() {
        if (tail == null) {
            throw new RuntimeException("The queue is empty");
        }
        //T result = tail.item;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
    }

    /**
     * Remove an element at the specified index.
     * @param index the index of the element to be removed.
     */
    public void remoteAt(int index) {
        checkIndex(index);
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(T item) {
        add(item);
        return true;
    }

    @Override
    public T poll() {
        return remove();
    }

    /**
     * Get the element at the front of the queue without removing it.
     * @return the element at the front of the queue.
     */
    @Override
    public T peek() {
        if (head == null) {
            throw new RuntimeException("The queue is empty");
        }
        return head.item;
    }

   public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Dequeue<Integer> queue = new Dequeue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.addAt(3, 33);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.remoteAt(7);
        System.out.println(queue);
    }
}
