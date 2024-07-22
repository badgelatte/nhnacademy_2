package com.nhnacademy.list.myLinkedList;

public class Node<E> {
    //data
    private E data;
    //next node
    private Node next;
    //prev node
    private Node prev;

    public Node(E e) {
        this.data = e;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
