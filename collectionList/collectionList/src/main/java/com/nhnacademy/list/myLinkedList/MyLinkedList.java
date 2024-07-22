package com.nhnacademy.list.myLinkedList;

import java.util.Iterator;

public class MyLinkedList<E> implements ILinekdList<E> , MyList<E> , Iterable<E> {
    private Node head;
    private Node tail;
    //linkedlist size
    private int size=0;

    @Override
    public boolean add(E element) {
        if(head==null) {
            head = new Node(element);
            tail = head;
            size++;
            return true;
        }

        Node nextNode = new Node(element);
        nextNode.setPrev(tail);
        tail.setNext(nextNode);
        tail = nextNode;
        size++;

        return true;
    }

    @Override
    public boolean remove(int index) {
        Node nextNode = null;
        if(index > 0) {
            while(index-- > 0) {
                nextNode = head.getNext();
            }
            nextNode.getPrev().setNext(nextNode.getNext());
            size--;
            return true;
        }
        if(size > 1){
            head = head.getNext();
            size--;
            return true;
        }
        tail = null;
        head = null;
        return true;

    }

    @Override
    public boolean remove(E e) {
        Node currentNode = head;
        if(size <= 1) {
            if(currentNode.getData() == e) {
                head = null;
                tail = null;
                return true;
            }
            return false;
        }
        while(currentNode!=null) {
            if(currentNode.getData().equals(e)) {
                currentNode.getPrev().setNext(currentNode.getNext());
                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        size--;
        return false;
    }

    @Override
    public E get(int index) {
        Node currentNode = head;
        while(index-->0) {
            currentNode = currentNode.getNext();
        }
        return (E) currentNode.getData();
    }

    @Override
    public E set(int index, E element) {
        Node currentNode = head;
        Node newNode = new Node(element);

        if(index == 0) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
            size++;
            return element;
        }
        if(index != 1 && index == size) {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
            size++;
            return element;
        }
        while(index-->0) {
            currentNode = currentNode.getNext();
        }
        newNode.setPrev(currentNode.getPrev());
        newNode.setNext(currentNode);
        currentNode.getPrev().setNext(newNode);
        currentNode.setPrev(newNode);
        size++;
        return element;
    }

    @Override
    public int indexOf(Object element) {
        int index = 0;
        Node currentNode = head;
        while(currentNode!=null) {
            if(currentNode.getData().equals(element)) {
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.getData().equals(o)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public void addFirst(E e) {
        Node newNode = new Node(e);
        head.setPrev(newNode);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public void addLast(E e) {
        Node newNode = new Node(e);
        tail.setNext(newNode);
        newNode.setPrev(tail);
        tail = newNode;
        size--;
    }

    @Override
    public E removeFirst() {
        Object result = head.getData();
        head = head.getNext();
        head.setPrev(null);
        return (E) result;
    }

    @Override
    public E removeLast() {
        Object result = tail.getData();
        tail = tail.getPrev();
        tail.setNext(null);
        return (E) result;
    }

    @Override
    public E getFirst() {
        if(head == null) return null;
        return (E) head.getData();
    }

    @Override
    public E getLast() {
        if(tail == null) return null;
        return (E) tail.getData();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                if(hasNext()) {
                    Object result = currentNode.getData();
                    currentNode = currentNode.getNext();
                    return (E) result;
                }
                return null;
            }
        };
    }
}

