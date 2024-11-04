package com.hzzz.www.array;

/**
 * Basic usage of one-dimensional array.
 */
public class Array {

    private int[] data;
    private int size;
    //private final int capacity;

    public Array(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative.");
        }
        //this.capacity = capacity;
        data = new int[capacity];
        size = 0;
    }

    /**
     * Add a value to the end of the array.
     * @param value the value to add.
     */
    public void add(int value) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size++] = value;
    }

    /**
     * Insert a value at a specific index.
     * @param index the index to insert the value.
     * @param value the value to insert.
     */
    public void insert(int index, int value) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    /**
     * Resize the array to a new capacity.
     * @param newCapacity the new capacity of the array.
     */
    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * Get the value at a specific index.
     * @param index the index to get the value.
     * @return the value at the index.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Set the value at a specific index.
     * @param index the index to set the value.
     * @param value the value to set.
     */
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        data[index] = value;
    }

    /**
     * Remove the value at a specific index.
     * @param index the index to remove the value.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }
}
