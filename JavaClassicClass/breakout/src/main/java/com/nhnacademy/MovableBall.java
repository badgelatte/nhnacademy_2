package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

/*
 * 그림이 가로, 세로 얼마나 움직이는가를 설정하는 class
 */
public class MovableBall extends PaintableBall implements Movable{
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
 
    public void bounce(Bounded bounded) {
        if(getBounds().intersects(bounded.getBounds())) {
            // 두 영역의 공통 영역 구하기
            Rectangle intersection = getBounds().intersection(bounded.getBounds());

            // ball과 공통 영역 / 다른 ball과 공통 영역이 각각 길이 혹은 높이 모두 맞지 않는다면 다른 방향으로 바꾸어라 
            if (intersection.getWidth() != getBounds().getWidth() && intersection.getWidth() != bounded.getWidth()) {
                setDx(-getDx());
            }

            if(intersection.getHeight() != getBounds().getHeight() && intersection.getHeight() != bounded.getHeight()) {
                setDy(-getDy());
            }
        }
    }
}
