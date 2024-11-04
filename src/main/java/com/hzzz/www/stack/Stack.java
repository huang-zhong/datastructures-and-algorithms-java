package com.hzzz.www.stack;

public interface Stack<T> {
    /**
     * 入栈
     * @param item 入栈元素
     */
    void push(T item);
    /**
     * 出栈
     * @return 出栈元素
     */
    T pop();
    /**
     * 取栈顶元素
     * @return 栈顶元素
     */
    T peek();
    /**
     * 判断栈是否为空
     * @return 栈是否为空
     */
    boolean isEmpty();
    /**
     * 栈大小
     * @return 栈大小
     */
    int size();
}
