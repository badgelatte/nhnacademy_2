package com.nhnacademy.list.myQueue;

import java.util.Iterator;

public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.add("white");
        queue.add("red");
        queue.add("blue");
        queue.offer("green");
        queue.offer("pink");

        Iterator<String> iterator = queue.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("############## poll");
        queue.poll();

        System.out.println("############## element, peek ");
        System.out.println("queue.element(): " + queue.element());
        System.out.println("queue.peek(): " + queue.peek());

        System.out.println("size:" + queue.size());

    }
}