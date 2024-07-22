package com.nhnacademy.list.myLinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList<Integer> list;

    @BeforeEach
    void setUp(){
        list = new MyLinkedList();
        for(int i = 0; i<20; i++){
            list.add(i);
        }
    }

    @Test
    void add() {
        list.add(21);
        int actual = list.getLast();
        Assertions.assertEquals(21, actual);
    }

    @Test
    void removeIndex() {
        list.remove(20);
        int actual = list.getLast();
        Assertions.assertEquals(19, actual);
    }

    @Test
    void removeElement() {
        MyLinkedList<String> list = new MyLinkedList();
        list.add("aaa");

        list.remove("aaa");
        Assertions.assertThrows(NullPointerException.class, ()
                -> list.getLast());
    }

    @Test
    void get() {
        Assertions.assertEquals(0,list.get(0));

    }

    @Test
    void set() {
        list.set(0, 21);
        Assertions.assertEquals(21,list.get(0));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(0,list.indexOf(0));
    }

    @Test
    void size() {
        Assertions.assertEquals(20,list.size());
    }

    @Test
    void contains() {
        Assertions.assertTrue(list.contains(10));
    }

    @Test
    void addFirst() {
        list.addFirst(200);
        Assertions.assertEquals(200,list.getFirst());
    }

    @Test
    void addLast() {
        list.addLast(200);
        Assertions.assertEquals(200,list.getLast());
    }

    @Test
    void removeFirst() {
        list.removeFirst();
        Assertions.assertEquals(1,list.getFirst());
    }

    @Test
    void removeLast() {
        list.removeLast();
        Assertions.assertEquals(18,list.getLast());
    }

    @Test
    void getFirst() {
        Assertions.assertEquals(0,list.getFirst());
    }

    @Test
    void getLast() {
        Assertions.assertEquals(19,list.getLast());
    }

    @Test
    void iterator() {
        Assertions.assertTrue(list.iterator().hasNext());

        Assertions.assertEquals(0,list.iterator().next());
    }
}