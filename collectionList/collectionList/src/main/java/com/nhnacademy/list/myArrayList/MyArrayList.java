package com.nhnacademy.list.myArrayList;

public class MyArrayList<E> implements MyList<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private int initCapacity;
    private Object[] elementData;
    private int size;

    public MyArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
        initCapacity = DEFAULT_CAPACITY;
    }

    public MyArrayList(int initCapacity){
        if(initCapacity < 0){
            throw new IllegalArgumentException();
        }
        elementData = new Object[initCapacity];
        this.initCapacity = initCapacity;
    }

    @Override
    public boolean add(E element) {
        if(size == elementData.length){
            Object[] newElementData = new Object[size + 1];
            for(int i = 0; i<elementData.length; i++){
                newElementData[i] = elementData[i];
            }
            elementData = newElementData;
        }
        for(int i =0; i<elementData.length; i++){
            if(elementData[i] == null){
                elementData[i] = element;
                size++;
                break;
            }
        }
        return true;
    }

    @Override
    public boolean remove(int index) {
        for(int i = index; i<elementData.length-1; i++){
            elementData[i] = elementData[i+1];
        }
        elementData[elementData.length-1] = null;
        size--;
        Object[] newElementData = new Object[size];
        for(int i = 0; i<newElementData.length; i++){
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
        return true;
    }

    @Override
    public boolean remove(E e) {
        for(int i =0; i<elementData.length; i++){
            if(elementData[i] == e){
                elementData[i] = null;
            }
        }
        for(int i = 0; i<elementData.length-1; i++) {
            if(elementData[i] == null){
                elementData[i] = elementData[i+1];
                elementData[i+1] = null;
            }
        }
        size--;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        Object result = elementData[index];
        return (E) result;
    }

    @Override
    public E set(int index, E element) {
        for(int i = elementData.length-1; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = element;
        size++;
        return element;
    }

    @Override
    public int indexOf(Object element) {
        for(int i =0; i<elementData.length; i++){
            if(elementData[i] == element){
                return i;
            }
        }
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for(int i =0; i<elementData.length; i++){
            if(elementData[i] == o){
                return true;
            }
        }
        return false;
    }
}
