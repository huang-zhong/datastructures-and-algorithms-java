package com.hzzz.www.list;

import java.util.Iterator;

public class ArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 1 << 3; //8
    private Object[] data;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        data = new Object[capacity];
        size = 0;
    }

    public void add(E e) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        data[size++] = e;
    }

    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @SuppressWarnings("unchecked")
    public E get(int index){
        checkDataIndex(index);
        return (E) data[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        size = 0;
    }

    public int indexOf(E e){
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E e){
        return indexOf(e) != -1;
    }

    public void remove(int index){
        checkDataIndex(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        // reduce capacity if necessary
        if (size <= data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
    }

    public void remove(E e){
        int index = indexOf(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void set(int index, E e){
        checkDataIndex(index);
        data[index] = e;
    }

    private void checkDataIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public String toString(){
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder(size);
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i!= size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void print(){
        if (size == 0) System.out.println("[]");
        else {
            System.out.println(this);
        }
    }

    /**
     * reverse the order of elements in the list
     */
    public void reverse(){
        for (int i = 0; i < size / 2; i++) {
            int j = size - i - 1;
            Object temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return (E) data[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
