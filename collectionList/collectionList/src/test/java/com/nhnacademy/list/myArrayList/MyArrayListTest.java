package com.nhnacademy.list.myArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>(20);
        for(int i=0; i < 20; i++) {
            list.add(i);
        }
    }

    @Test
    @DisplayName("instance of MyList")
    void instanceOfMyList(){
        MyList<String> actual = new MyArrayList<>();
        Assertions.assertInstanceOf(MyList.class, actual);
    }

    @Test
    @DisplayName("initCapacity > 0")
    void checkInitCapacity() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new MyArrayList<String>(-10);
        });
    }

    @Test
    void add() {
        list.add(100);
        int actual = list.size();
        Assertions.assertEquals(21, actual);
    }

    @Test
    void remove() {
        list.remove(0);
        int actual = list.get(0);
        Assertions.assertEquals(1, actual);
    }

    @Test
    void testRemove() {
    }

    @Test
    void get() {
    }

    @Test
    void set() {
    }

    @Test
    void indexOf() {
    }

    @Test
    void size() {
    }

    @Test
    void contains() {
    }
}