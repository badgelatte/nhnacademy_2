package com.nhnacademy;

import java.util.Arrays;

public class example3 {
    public static void main(String[] args) {
        // 반복문으로 순차처리
        int[] a = new int[] {1,2,3,4,5};
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

        Arrays.stream(a).forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println();

    }
    
}