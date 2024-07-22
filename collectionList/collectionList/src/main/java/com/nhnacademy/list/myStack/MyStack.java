package com.nhnacademy.list.myStack;

import com.nhnacademy.list.myArrayList.MyArrayList;

import java.util.Iterator;

public class MyStack<E> extends MyArrayList<E> implements IStack<E> , Iterable<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int initCapacity;
    private Object[] elementData;

    public MyStack() {
        elementData = new Object[DEFAULT_CAPACITY];
        initCapacity = DEFAULT_CAPACITY;
    }

    public MyStack(int capacity) {
        elementData = new Object[capacity];
    }

    @Override
    public void push(E item) {
        if(elementData[elementData.length-1]!= null) {
            Object[] newElementData = new Object[elementData.length*2];
            for(int i=0; i<elementData.length; i++){
                newElementData[i] = elementData[i];
            }
            newElementData[elementData.length+1] = item;
            elementData = newElementData;
            return;
        }

        for(int i = 0; i< elementData.length; i++) {
            if(elementData[i] == null) {
                elementData[i] = item;
                return;
            }
        }
    }

    @Override
    public E pop() {
        for(int i = 0; i< elementData.length; i++) {
            if(elementData[i] == null) {
                Object data = elementData[i-1];
                elementData[i-1] = null;
                if(elementData.length % initCapacity == 1) {
                    int share = elementData.length / initCapacity;
                    Object[] newElementData = new Object[elementData.length*share];
                    for(int j = 0; j< newElementData.length; j++) {
                        newElementData[j] = elementData[j];
                    }
                    elementData = newElementData;
                }
                return (E) data;
            }
        }
        return null;
    }

    @Override
    public E peek() {
        for(int i = 0; i< elementData.length; i++) {
            if(elementData[i] == null) {
                return (E) elementData[i-1];
            }
        }
        return (E) elementData[elementData.length-1];
    }

    @Override
    public int search(Object o) {
        for(int i = 0; i< elementData.length; i++) {
            if(elementData[i].equals(o)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public boolean empty() {
        return elementData[0] == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            @Override
            // 현재 요소가 있는가를 가르킨다
            public boolean hasNext() {
                return index < elementData.length && elementData[index] != null;
            }

            @Override
            // 현재의 요소를 출력하고 다음 요소를 가르킨다
            public E next() {
                if(index >= elementData.length || elementData[index] == null) {
                    return null;
                }
                return (E) elementData[index++];
            }

            /*private int findLastIndex() {
                for(int i = 0; i< elementData.length; i++) {
                    if(elementData[i] == null) {
                        return i;
                    }
                }
                return -1;
            }*/
        };
    }
}
