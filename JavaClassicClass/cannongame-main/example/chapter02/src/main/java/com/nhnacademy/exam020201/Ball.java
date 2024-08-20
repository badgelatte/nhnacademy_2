package com.nhnacademy.exam020201;

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
        if (radius <= 0) {
            throw new InvalidSizeException();
        }

        if (((long) x + radius > Integer.MAX_VALUE)
                || ((long) x - radius < Integer.MIN_VALUE)) {
            throw new OutOfRangeException("볼의 영역이 X축의 허용 범위를 벗어납니다.");
        }

        if (((long) y + radius > Integer.MAX_VALUE)
                || ((long) y - radius < Integer.MIN_VALUE)) {
            throw new OutOfRangeException("볼의 영역이 Y축의 허용 범위를 벗어납니다.");
        }

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

    public int getMinX() {
        return x - radius;
    }

    public int getMaxX() {
        return x + radius;
    }

    public int getMinY() {
        return y - radius;
    }

    public int getMaxY() {
        return y + radius;
    }
}