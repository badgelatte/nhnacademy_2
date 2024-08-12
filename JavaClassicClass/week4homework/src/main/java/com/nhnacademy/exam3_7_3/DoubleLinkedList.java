package com.nhnacademy.exam3_7_3;

import com.nhnacademy.SimpleList;
import com.nhnacademy.SimpleListIterator;

public class DoubleLinkedList implements SimpleList{
    class ListIterator implements SimpleListIterator {
        Node head;
        Node first = new Node(0);
        public ListIterator(Node head){
            head.previous = first;
            first.next = head;            
            this.head = first;
        }

        @Override
        public boolean hasNext() {
            return head.next != null;
        }

        @Override
        public boolean hasPrevious() {
            if(head.previous == first) {
                head = head.previous;
                return false;
            }
            return head.previous != null;
        }

        @Override
        public int next() {
            if(head.next == null) {
                throw new IllegalArgumentException();
            }
            int result = head.next.data;
            head = head.next;
            return result;
        }

        @Override
        public int previous() {
            if(!hasPrevious()) {
                throw new IllegalAccessError();
            }
            int result = head.previous.data;
            head = head.previous;
            return result;
        }

        @Override
        public void remove() {
            if(head.next != null) {
                if(head.next.next == null) {
                    head.next = null;
                }
                head.next.next.previous = head;
                head.next = head.next.next;
            }
        }

    }
    class Node {
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this(data, null, null);
        }

        public Node(int data, Node next) {
            this(data, null, next);
        }

        public Node(int data, Node previous, Node next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

    }

    Node head;
    int size;

    @Override
    public void add(int data) {
        Node start = head;
        if(start == null) {
            start = new Node(data);
            head = start;
            size++;
            return;
        }
        while(start != null) {
            if(start.next == null) {
                start.next = new Node(data, start, null);
                size++;
                return;
            }
            start = start.next;
        }
    }

    @Override
    public boolean contains(int data) {
        Node start = head;
        int countdown = size;
        while(countdown-->0) {
            if(start.data == data) {
                return true;
            }
            start = start.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int remove() {
        int data = head.data;
        head = head.next;
        head.previous = null;
        size--;
        return data;
    }

    public int removeAt(int index) {
        Node start = head;
        while (index-- > 0) {
            start = start.next;
        }
        int data = start.data;

        if(start.previous == null) {
            start.next.previous = null;
            size--;
            return data;
        }

        if(start.next == null) {
            start.previous.next = null;
            size--;
            return data;
        }
        start.previous.next = start.next;
        start.next.previous = start.previous;
        size--;
        return data;
    }

    @Override
    public boolean remove(int data) {
        if(head.data == data) {
            remove();
            return true;
        }
        Node start = head;
        while(start != null) {
            if(start.data == data) {
                if(start.next != null) {
                    start.next.previous = start.previous;
                    start.previous.next = start.next;
                }else {
                    start.previous.next = null;
                }
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
        return new ListIterator(head);
    }

    @Override
    public String toString(){
        Node start = head;
        String result = "[" + start.data;
        while (start.next != null) {
            start = start.next;
            result += (", " + start.data);
        }
        result += "]";
        return result;
    }

    public static void main(String[] args) {
        SimpleList list = new DoubleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.contains(2));
        System.out.println(list.size());
        System.out.println(list.toString());
        list.remove(2);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());
        
        SimpleListIterator iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }        
        System.out.println();
        
        iterator.remove();
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println(list.toString());
    }
}
