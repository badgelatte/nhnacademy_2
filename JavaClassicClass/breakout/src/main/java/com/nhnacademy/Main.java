package com.nhnacademy;

import java.awt.Frame;
import java.awt.Graphics;

public class Main extends Frame {
    static final int x = 100;
    static final int y = 200;
    static final int radius = 50;
    PaintableBall ball = new PaintableBall(x, y, radius);
    
    public static void main(String[] args) {
        // Ball ball = new Ball(100, 200, 30);
        // System.out.println("X : " + ball.getX());
        // System.out.println("Y : " + ball.getY());
        // System.out.println("Radius : " + ball.getRadius());
        // System.out.println(ball);

        int x = 100;
        int y = 200;
        int radius = 50;

        Main frame = new Main();

        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("Paint called");
        ball.paint(g);
    }
}