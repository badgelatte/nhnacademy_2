package com.nhnacademy.exam020103;

public class Main {

    /**
     * 테스트 메인.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        try {
            new Ball(10, 10, 0);
        } catch (InvalidSizeException e) {
        }

        try {
            new Ball(10, 10, Integer.MAX_VALUE);
        } catch (OutOfRangeException e) {
        }
    }
}
