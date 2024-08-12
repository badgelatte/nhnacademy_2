package com.nhnacademy.exam3_7_5;

import java.util.Random;

import com.nhnacademy.SimpleList;
import com.nhnacademy.exam3_7_1.SimpleArrayList;
import com.nhnacademy.exam3_7_3.DoubleLinkedList;
import com.nhnacademy.exam3_7_4.CircularLinkedList;

public class Josephus {
    // public static void main(String[] args) {
    //     DoubleLinkedList list = new DoubleLinkedList();

    //     int random1 = 0;
    //     int random2 = 0;
    //     while(random1 <= random2) {
    //         random1 = new Random().nextInt(10);
    //         random2 = new Random().nextInt(4) + 2;
    //     }
    //     for (int i = 1; i <= random1; i++) {
    //         list.add(i);
    //     }

    //     int location = 0;
    //     while (list.size() > 1) {
    //         int size = list.size();
    //         for (int i = 0; i < size; i++) {
    //             if(((i+1) % (random2))+location== 0) {
    //                 list.removeAt(i);
    //             }
    //             if(list.size() == 1){
    //                 break;
    //             }
    //         }
    //         location = size % random2 -1;
    //     }
    //     System.out.println(list.toString());
    // }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        int random1 = 0;
        int random2 = 0;
        while(random1 <= random2) {
            random1 = new Random().nextInt(10);
            random2 = new Random().nextInt(4) + 2;
        }

        for (int i = 1; i <= random1; i++) {
            list.add(i);
        }
        String a="[ ";

        int last = 1;
        int s = list.size();

        System.out.println("["+random1+", "+random2+"]");
        System.out.println(list.toString());

        while(list.size() > 1) {
            for (int i = 0; i < s; i++) {
                int data = list.remove();
                if(last != random2){
                    last++;
                    list.add(data);
                }
                else {
                    last = 1;
                    a += (data + " ");
                    System.out.println(list.toString());
                }
            }
            s = list.size();
        }
        int data = list.remove();
        System.out.println(a+ data + " ]");
    }
}
