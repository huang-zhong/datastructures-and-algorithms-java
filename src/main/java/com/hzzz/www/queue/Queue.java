package com.hzzz.www.queue;

public interface Queue<T> {
   void add(T item);
   T remove();
   boolean isEmpty();
   int size();
   boolean offer(T item);
   T poll();
   T peek();
}
