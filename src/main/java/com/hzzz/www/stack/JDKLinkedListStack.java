package com.hzzz.www.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class JDKLinkedListStack<E> implements Stack<E>, Iterable<E> {
    private final LinkedList<E> data = new LinkedList<>();
    @Override
    public void push(E item) {
        data.addFirst(item);
    }

    @Override
    public E pop() {
        if (data.isEmpty()) {
            throw new EmptyStackException();
        }
        return data.removeFirst();
    }

    @Override
    public E peek() {
        if (data.isEmpty()) {
            throw new EmptyStackException();
        }
        return data.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }
}
