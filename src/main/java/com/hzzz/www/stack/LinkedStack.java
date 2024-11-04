package com.hzzz.www.stack;

import java.util.EmptyStackException;

/**
 * 链表实现栈
 * @param <T>
 */
public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public LinkedStack(T val){
        top = new Node<>(val);
        size = 1;
    }


    @Override
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++; // 栈顶指针指向新节点
    }

    @Override
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T val = top.val;
        top = top.next;
        size--;
        return val;
    }

    @Override
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<T> {
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
            this.next = null;
        }
    }
}
