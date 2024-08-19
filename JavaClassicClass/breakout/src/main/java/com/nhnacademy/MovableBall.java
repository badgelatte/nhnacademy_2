package com.nhnacademy;

import java.awt.Color;

/*
 * 그림이 가로, 세로 얼마나 움직이는가를 설정하는 class
 */
public class MovableBall extends PaintableBall {
    int dx;
    int dy;
    
    public MovableBall(int x, int y, int radius) {
        super(x, y, radius);
    }
    
    public MovableBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void move(){
        System.out.printf("(%d %d) -> %n", getX(), getY());
        moveTo(getX() + dx, getY() + dy);
        System.out.printf("(%d %d) -> %n", getX(), getY());
    }

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }

    
}
