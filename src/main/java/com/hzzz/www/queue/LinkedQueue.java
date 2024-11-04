package com.hzzz.www.queue;

/**
 * LinkedQueue is a queue implemented of linked list.
 * It has two pointers, head and tail, to keep track of the first and last nodes of the list.
 * @param <T>
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedQueue(T val){
        head = new Node<>(val);
        tail = head;
        size = 1;
    }

    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public T remove() {
        if (head == null) {
            throw new RuntimeException("Queue is empty");
        }
        T item = head.item;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return item;
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
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.item;
    }

    private static class Node<T>{
        Node<T> next;
        T item;
        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
        public Node(T item) {
            this(item, null);
        }
    }
}
