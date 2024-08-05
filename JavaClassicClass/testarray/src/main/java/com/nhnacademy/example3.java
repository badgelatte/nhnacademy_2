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

        // 짝수만 출력
        int[] a2 = new int[] {1,2,3,4,5};
        for (int i = 0; i < a2.length; i++) {
            if(a2[i] % 2 == 0) {
                System.out.print(a2[i] + " ");
            }
        }
        System.out.println();

        for (int value : a2) {
            if(value % 2 == 0) {
                System.out.print(value + " ");
            }
        }
        System.out.println();

        Arrays.stream(a2).filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + " "));
    }
    
}