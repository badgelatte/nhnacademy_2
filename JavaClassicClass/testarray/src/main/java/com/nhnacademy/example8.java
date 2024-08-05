package com.nhnacademy;

import java.util.Arrays;

import com.nhnacademy.example7.Box;

public class example8 {
    public static int search(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if(a[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int search(Box[] a, Box x) {
        for (int i = 0; i < a.length; i++) {
            if(a[i] == x) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {22,33,44,55,66,77,88,99};

        System.out.println(Arrays.toString(a));

        Box[] boxes = {new Box(1), new Box(2), new Box(3)};
        Box box2 = new Box(2);

        
        System.out.println("search(a, 44): " + search(a, 44));
        System.out.println("search(a, 44): " + search(a, 50));
        System.out.println("search(a, 44): " + search(a, 77));
        System.out.println("search(a, 44): " + search(a, 100));
        // reference 비교는 되지 않는다 -> 값이 같아도 다른 객체이다
        System.out.println("search(a, 44): " + search(boxes, box2)); 
        // boxes안의 box로 비교하는 것이기 때문에 같은 객체를 찾은 것이다
        System.out.println("search(a, 44): " + search(boxes, boxes[1])); 
    }
}
