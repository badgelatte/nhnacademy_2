package com.nhnacademy.list.myLinkedList;

import java.util.Iterator;

public class MyLinkedListMain {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("red");
        list.add("green");
        list.add("white");
        list.add("blue");
        list.removeFirst();
        list.removeLast();
        System.out.println("list.getFirst():" + list.getFirst());
        System.out.println("list.getLast():" + list.getLast());
        list.addLast("pink");
        list.addFirst("yellow");
        System.out.println("### for loop ###");

        System.out.println("### Iterator ###");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println("color:" + iterator.next());
        }
    }
}