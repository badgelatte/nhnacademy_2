package com.nhnacademy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers;
        Object objects[];

        numbers = new int[] {1,2,3,4,5};    // 초기값 주기 -> new int [] 생략 가능
        objects = new Object[10];

        int[][] doubleNum = {{0,1}, {2,3}, {4,5}};
        int[][] doubleNum2 = {{0,1}, null, {3, 4, 5, 6}};

        System.out.println("numbers= " + Arrays.toString(numbers));
        System.out.println("objects= " + Arrays.toString(objects));
        System.out.println("objects= " + Arrays.toString(doubleNum));
        System.out.println("objects= " + Arrays.toString(doubleNum2));
    }
}