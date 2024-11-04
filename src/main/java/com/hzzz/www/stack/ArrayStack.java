package com.hzzz.www.stack;

import java.util.EmptyStackException;

/**
 * 数组实现的栈
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T> {
    private Object[] data;
    private int size;
    private int capacity;

    public ArrayStack() {
        capacity = 16;
        data = new Object[capacity];
        size = 0;
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        size = 0;
    }

    @Override
    public void push(T item) {
        if (size == capacity) {
            // 扩容
            resize(capacity * 2);
        }
        data[size++] = item;
    }

    private void resize(int capacity) {
        Object[] newData = new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        this.capacity = capacity;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = (T) data[--size];
        data[size] = null;
        if (size > 0 && size == capacity / 4) {
            // 缩容
            resize(capacity / 2);
        }
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) data[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
