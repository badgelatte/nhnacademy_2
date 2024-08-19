package com.nhnacademy;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;

public class Main_world extends Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        World world = new World();

        frame.add(world);
        frame.setSize(500, 400);
        frame.setVisible(true);

        Ball ball = new PaintableBall(100, 100, 50);
        Ball ball2 = new PaintableBall(200, 200, 50, Color.BLUE);
        world.add(ball);
        world.add(ball2);
    }
}
