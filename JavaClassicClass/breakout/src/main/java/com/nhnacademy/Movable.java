package com.nhnacademy;

public interface Movable {
    public int getDx();
    public int getDy();
    public void setDx(int dx);
    public void setDy(int dy);
    public void move();
    public void moveTo(int x, int y);
    public void bounce(Bounded bounded);
}
