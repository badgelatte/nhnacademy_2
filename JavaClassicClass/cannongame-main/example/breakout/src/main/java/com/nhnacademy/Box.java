package com.nhnacademy;

import java.awt.Rectangle;

public class Box implements Bounded{
    int x;
    int y;
    int width;
    int height;

    public Box(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getBounds(){
        return new Rectangle(getMinX(), getMinY(), getWidth(), getHeight());
    } 
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMinX() {
        return x - width/2;
    }

    public int getMaxX() {
        return x + width/2;
    }

    public int getMinY() {
        return y - height/2;
    }

    public int getMaxY() {
        return y + height/2;
    }

}
