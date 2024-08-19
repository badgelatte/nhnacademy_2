package com.nhnacademy;

public class Ball {
    int x;
    int y;
    int radius;

    public Ball(int x, int y, int radius) {
        if((long)(x - radius) < Integer.MIN_VALUE
        || (long)(y + radius) > Integer.MAX_VALUE
        || (long)(y - radius) < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("볼이 해당 공간을 벗어났습니다");
        }
        if(radius < 0) {
            throw new IllegalArgumentException("반지름은 음수가 될 수 없습니다");
        }

        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public String toString(){
        return "(" + x + ", " + y + ", " + radius + ")";
    }
    
}

    