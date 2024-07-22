package com.nhnacademy.list.myStack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {
    private MyStack<Integer> myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();
        for(int i = 0; i <= 8; i++) {
            myStack.push(i);
        }
    }

    @Test
    void push() {
        myStack.push(100);
        Assertions.assertEquals(100, myStack.peek());
    }

    @Test
    void pop() {
        Integer result = myStack.pop();
        Assertions.assertEquals(8, result);
    }

    @Test
    void peek() {
        Integer result = myStack.peek();
        Assertions.assertEquals(8, result);
    }

    @Test
    void search() {
        Integer result = myStack.search(3);
        Assertions.assertEquals(3, result);
    }

    @Test
    void empty() {
        Assertions.assertFalse(myStack.empty());
    }

    @Test
    void iterator() {
        Assertions.assertTrue(myStack.iterator().hasNext());
        Assertions.assertEquals(0, myStack.iterator().next());
    }
}