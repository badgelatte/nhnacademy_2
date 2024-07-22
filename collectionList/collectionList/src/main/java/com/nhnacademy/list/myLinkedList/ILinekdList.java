package com.nhnacademy.list.myLinkedList;

public interface ILinekdList<E>{
    void addFirst(E e);
    void addLast(E e);
    E removeFirst();
    E removeLast();
    E getFirst();
    E getLast();
}
