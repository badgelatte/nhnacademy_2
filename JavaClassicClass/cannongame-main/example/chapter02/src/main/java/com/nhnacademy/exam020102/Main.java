package com.nhnacademy.exam020102;

/**
 * Ball 클래스 테스트.
 */
public class Main {
    /**
     * 테스트 메인.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        int x = 100;
        int y = 100;
        int radius = 20;

        Ball ball = new Ball(x, y, radius);

        System.out.println("볼은 X축 " + ball.getMinX() + "에서 " + ball.getMaxX() + "와 "
                + "Y축 " + ball.getMinY() + "에서 " + ball.getMaxY() + "에 위치합니다.");
    }
}
