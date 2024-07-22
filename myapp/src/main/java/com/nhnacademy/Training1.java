package com.nhnacademy;

import java.util.Random;

public class Training1 {
    /**
     * 1부터 100까지 난수 생성하기
     * @param args
     */
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println(rand.nextInt(99)+1);
    }
}
