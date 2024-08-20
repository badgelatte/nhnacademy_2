package com.nhnacademy.exam020101;

/**
 * 2차원 공간에서의 볼을 표현하기 위한 최소한의 정보만 가짐.
 */
public class Ball {
    int x;
    int y;
    int radius;

    /**
     * 2차원 평면에서의 x,y 좌표와 반지름을 받아 볼 생성
     *
     * @param x      X축 좌표
     * @param y      Y축 좌표
     * @param radius 반지름
     */
    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + getRadius() + ")";
    }
}