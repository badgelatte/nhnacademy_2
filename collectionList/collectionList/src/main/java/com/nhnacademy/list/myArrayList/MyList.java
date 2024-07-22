package com.nhnacademy.list.myArrayList;

public interface MyList<E> {
    boolean add(E element);
    //index 번 째의 element 삭제
    boolean remove(int index);
    //remove first ... 처음 발견되는 element 삭제
    boolean remove(E e);
    E get(int index) throws Exception;
    E set(int index, E element);
    int indexOf(Object element);
    int size();
    boolean contains(Object o);
}