package com.nhnacademy;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class Mains {
    static final int FRAME_WIDTH = 500;
    static final int FRAME_HEIGHT = 400;
    static final int BALL_COUNT = 2;
    static final int MOVE_COUNT = 0;
    static final Color[] colors = new Color[] {
            Color.BLUE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN
    };

    public static void main(String[] args) {
        Random random = new Random();
        JFrame frame = new JFrame();

        BoundedWorld world = new BoundedWorld();

        frame.add(world);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);

        MovableBall powerBall = new MovableBall(FRAME_WIDTH / 2, FRAME_HEIGHT - 50, 20, Color.RED);
        powerBall.setDX(5);
        powerBall.setDY(-4);
        world.add(powerBall);

        int brickWidth = FRAME_WIDTH/ 10;
        int brickHeight = 40;
        int brickX = FRAME_WIDTH / 10 /2;
        int brickY = 40;

        for (int yi = 0; yi < 2; yi++) {
                for (int xi = 0; xi < 10; xi++) {
                PaintableBox brick = new PaintableBox(
                    brickX + xi * brickWidth, 
                    brickY + yi * brickHeight, 
                    brickWidth / 2 - 4,
                    brickHeight / 2 -4);
                world.add(brick);
            }
        }
        frame.repaint();

        world.setMaxMoveVount(MOVE_COUNT);
        world.run();
    }
}
