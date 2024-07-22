package com.nhnacademy.list.myQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    private MyQueue<Integer> myQueue;

    @BeforeEach
    void setUp() {
        myQueue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            myQueue.add(i);
        }
    }

    @Test
    void element() {
        Assertions.assertEquals(0, myQueue.element());
    }

    @Test
    void offer() {
        Assertions.assertTrue(myQueue.offer(1));
    }

    @Test
    void poll() {
        Assertions.assertEquals(0, myQueue.poll());
    }

    @Test
    void peek() {
        Assertions.assertEquals(9, myQueue.peek());
    }
}