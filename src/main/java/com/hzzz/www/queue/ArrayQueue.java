package com.hzzz.www.queue;

/**
 *  ArrayQueue is an implementation of Queue using an array.
 *  It has a fixed capacity and supports add, remove, and poll operations.
 *  It also supports peek operation to get the first element of the queue.
 *  It uses a circular array to implement the queue.
 *  When the capacity is reached, the array is resized to double its size.
 *  When the size is less than half of the capacity, the array is resized to half its size.
 *  The time complexity of add, remove, and poll operations is O(1).
 *  The time complexity of peek operation is O(1).
 *  The space complexity is O(n), where n is the capacity of the queue.
 * @param <T>
 */
public class ArrayQueue<T> implements Queue<T> {
    private Object[] data;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue() {
        data = new Object[10];
        head = 0;
        tail = 0;
        size = 0;
    }

    public ArrayQueue(int capacity) {
        data = new Object[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    /**
     * Add an element to the end of the queue.
     * @param item the element to be added.
     */
    @Override
    public void add(T item) {
        if (size == data.length) {
           resize(2 * data.length);
        }
        data[tail] = item;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * Remove and return the first element of the queue.
     * @return the first element of the queue.
     */
    @Override
    @SuppressWarnings("unchecked")
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T item = (T) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        if (size < data.length / 4 && data.length > 10) {
            resize(data.length / 2);
        }
        return item;
    }

    private void resize(int capacity) {
        Object[] newData = new Object[capacity];
        for (int i = 0; i < newData.length; i++) {
            newData[i] = data[(head + i) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Add an element to the end of the queue.
     * @param item the element to be added.
     * @return true if the element is added successfully.
     */
    @Override
    public boolean offer(T item) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[tail] = item;
        tail = (tail + 1) % data.length;
        size++;
        return true;
    }

    /**
     * Remove and return the first element of the queue.
     * @return the first element of the queue.
     */
    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T item = (T) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        if (size < data.length / 4 && data.length > 10) {
            resize(data.length / 2);
        }
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) data[head];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: [");
        for (int i = 0; i < size; i++) {
            sb.append(data[(head + i) % data.length]);
            if (i!= size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        //System.out.println("size: " + queue.size() + ", data length: " + queue.data.length);
        for (int i = 0; i < 10; i++) {
            queue.add(i);
            //System.out.println("size: " + queue.size() + ", data length: " + queue.data.length);
        }
        //Assertions.assertEquals("Queue: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", queue.toString());
        System.out.println(queue);
        System.out.println("size: " + queue.size() + ", data length: " + queue.data.length);
        //for (int i = 0; i < 1; i++) {
            queue.poll();
            //System.out.println("size: " + queue.size() + ", data length: " + queue.data.length);
        //}
        queue.remove();
        //Assertions.assertEquals("Queue: [1, 2, 3, 4, 5, 6, 7, 8, 9]", queue.toString());
        queue.add(11);
        queue.add(12);
        queue.offer(13);
        //Assertions.assertEquals("Queue:[]", queue.toString());
        System.out.println(queue);
        System.out.println("size: " + queue.size() + ", data length: " + queue.data.length);
    }
}
