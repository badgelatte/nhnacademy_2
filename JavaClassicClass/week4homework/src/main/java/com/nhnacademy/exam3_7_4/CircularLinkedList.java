package com.nhnacademy.exam3_7_4;

import com.nhnacademy.SimpleList;
import com.nhnacademy.SimpleListIterator;

public class CircularLinkedList implements SimpleList{
    class Node {
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this(data, null, null);
        }

        public Node(int data, Node previous, Node next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    class ListIterator implements SimpleListIterator {
        Node head;
        Node tail;

        public ListIterator(Node head, Node tail){
            this.head = head;
            this.tail = tail;
        }

        @Override
        public boolean hasNext() {
            return !(head == null || head.next == tail.next);
        }

        @Override
        public boolean hasPrevious() {
            return !(head == null || head.previous == tail);
        }

        @Override
        public int next() {
            if(!hasNext()) {
                return 0;
            }
            int result = head.data;
            head = head.next;
            return result;
        }

        @Override
        public int previous() {
            if(!hasPrevious()) {
                return 0;
            }
            int result = head.data;
            head= head.previous;
            return result;
        }

        @Override
        public void remove() {
            if(head.next == head) {
                head = null;
            }
            head = head.next.next;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(int data) {
        if(head == null) {
            Node node = new Node(data, null, null);
            node.next = node;
            node.previous = node;
            head = node;
            tail = node;
            size++;
            return;
        }
        if(head == tail) {
            Node node = new Node(data, tail, head);
            head.next = node;
            head.previous = node;
            tail = node;
            size++;
            return;
        }
        // head= 1 / tail = 2 /new = 3
        Node node = new Node(data, tail, head);
        tail.next = node;
        tail = node;
        head.previous = tail;
        size++;
    }

    @Override
    public boolean contains(int data) {
        Node start = head.next;
        if(head.data == data) {
            return true;
        }
        while(start != head) {
            if(start.data == data) {
                return true;
            }
            start = start.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size<=0;
    }
    
    @Override
    public int remove() {
        if(head == null) {
            throw new IllegalArgumentException();
        }

        int data = head.data;

        if(head == tail) {
            head = null;
            tail = null;
            size--;
            return data;
        }
        head = head.next;
        head.previous = tail;
        tail.next = head;
        size--;
        return data;
    }

    public int removeAt(int index) {
        if(index > size) {
            throw new IllegalArgumentException();
        }
        Node start = head;
        while(index-- > 0){
            start = start.next;
        }
        int data = start.data;
        if(size==1) {
            head = null;
            tail = null;
            size--;
            return data;
        }
        if(start == head) {
            head = start.next;
            tail.next = head;
            head.previous = tail;
            size--;
            return data;
        }
        if(start == tail) {
            tail = start.previous;
            tail.next = head;
            head.previous = tail;
            size--;
            return  data;
        }
        start.previous.next = start.next;
        start.next.previous = start.previous;
        size--;
        return data;
    }

    @Override
    public boolean remove(int data) {
        Node start = head;
        while(start.next != head) {
            if(start.next.data == data) {
                if(start.next == tail) {
                    tail = start;
                }
                start.next = start.next.next;
                size--;
                return true;
            }
            start = start.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SimpleListIterator iterator() {
        return new ListIterator(head, tail);
    }

    @Override
    public String toString() {
        Node start = head;
        String result ="[";
        while(start != tail) {
            result += (start.data + ", ");
            start = start.next;
        }
        result += (start.data + "]");
        return result;
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        // System.out.println(list.toString() + ", head : " + list.head.data + ", tail: " + list.tail.data);
        // list.remove();
        // System.out.println(list.size());
        // System.out.println(list.toString() + ", head : " + list.head.data + ", tail: " + list.tail.data);
        // list.add(4);
        // System.out.println(list.toString() + ", head : " + list.head.data + ", tail: " + list.tail.data);
        // list.remove(4);
        // System.out.println(list.toString() + ", head : " + list.head.data + ", tail: " + list.tail.data);
        // System.out.println("list is empty : " + list.isEmpty());
        // System.out.println("contain 1: " + list.contains(1));
        // System.out.println("contain 3: " + list.contains(3));

        SimpleListIterator ite = list.iterator();
        while(ite.hasNext()) {
            System.out.println(ite.next());
        }
        System.out.println();
        while(ite.hasPrevious()) {
            System.out.println(ite.previous());
        }
    }
}