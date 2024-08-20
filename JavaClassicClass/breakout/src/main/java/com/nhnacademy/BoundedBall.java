package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall{
    Rectangle bounds;

    public BoundedBall(int x, int y, int radius) {
        super(x, y, radius);
        bounds = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);
        bounds = new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        // this.bounds = bounds -> 이건 bounds 객체 주소를 연결하는건데 받은 bounds 객체 속 값이 바뀌면 연결된 모든 BoundedBall의 bounds 필드 속 값이 같이 바뀐다
        // 그래서 각자 객체로 다시 만들어서 각각 값을 가지도록 하는 것이다
        // deep clone
        this.bounds = new Rectangle(bounds);
    }

    public  boolean isOutOfBounds(){
        return (getMinX() < bounds.getMinX())
        || (bounds.getMaxX() < getMaxX())
        || ((getMinY() < bounds.getMinY()))
        || (bounds.getMaxY() < getMaxY());
    }

    @Override
    public void move(){
        super.move();
        if(isOutOfBounds()) {
            bounce();
        }
    }

    public void bounce(){
        if((getMinX() < bounds.getMinX()) || (bounds.getMaxX() < getMaxX())){
            setDx(-getDx());
        }
        if((getMinY() < bounds.getMinY()) || (bounds.getMaxY() < getMaxY())) {
            setDy(-getDy());
        }
     }


}
