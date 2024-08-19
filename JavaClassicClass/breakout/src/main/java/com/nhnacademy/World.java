package com.nhnacademy;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class World  extends JPanel{
    List<Ball> ballList;

    public World(){
        super();
        ballList = new ArrayList<>();
    }

    public void add(Ball ball) {
        if(ball == null) {
            throw new IllegalArgumentException();
        }

        // 내가 시도한 것
        // if(getBounds().getMaxX() < ball.getX() + ball.getRadius() ||
        // getBounds().getMaxY() < ball.getY() + ball.getRadius() ||
        // getBounds().getMinX() > ball.getX() - ball.getRadius() ||
        // getBounds().getMinY() > ball.getY() - ball.getRadius() ) {
        //     return;
        // }

        // world를 벗어나는, 화면을 벗어나는 경우 exception을 던져 나오지 않도록 만든다
        // if(getWidth() < ball.getX() + ball.getRadius()
        // || (ball.getX() - ball.getRadius()) < 0
        // || getHeight() < ball.getY() + ball.getRadius()
        // || (ball.getY() - ball.getRadius()) < 0) {

        if(getWidth() < ball.getMaxX()
        || ball.getMinX() < 0
        || getHeight() < ball.getMaxY()
        || ball.getMinY() < 0) {
            throw new IllegalArgumentException("ball이 world를 벗어 났습니다.");
        }

        ballList.add(ball);
        System.out.printf("Add ball: %3d, %3d, %3d %n", ball.getX(), ball.getY(), ball.getRadius());
    }

    public void remove(Ball ball) {
        ballList.remove(ball);
    }

    public void remove(int index) {
        ballList.remove(index);
    }

    public int getCount(){
        return ballList.size();
    }

    public Ball get(int index) {
        return ballList.get(index);
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Ball ball : ballList) {
            if(ball instanceof PaintableBall) {
                ((PaintableBall)ball).paint(g);
            }
        }
    }

}