package com.nhnacademy.list.myQueue;

import com.nhnacademy.list.myLinkedList.MyLinkedList;

import java.util.NoSuchElementException;

public class MyQueue<E> extends MyLinkedList<E> implements IQueue<E> {

    @Override
    public E element() {
        E result = getFirst();
        if(result == null) {
            throw new NoSuchElementException();
        }
        return result;
    }

    @Override
    public boolean offer(E e) {
        try{
            add(e);
            return true;
        } catch (IllegalStateException ex) {
            return false;
        }
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E peek() {
        return getLast();
    }
}