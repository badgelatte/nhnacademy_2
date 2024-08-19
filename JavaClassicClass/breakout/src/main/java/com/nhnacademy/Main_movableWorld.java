package com.nhnacademy;

import java.awt.Color;
import java.awt.Frame;
import java.util.Random;

import javax.swing.JFrame;

public class Main_movableWorld extends Frame {
    static final int FRAME_WIDTH = 500;
    static final int FRAME_HEIGHT = 400;
    static final int BALL_COUNT = 10;
    static final Color[] colors = new Color[]{
        Color.BLUE, Color.BLACK, Color.WHITE, Color.RED, Color.GREEN
    };

    public static void main(String[] args) {
        Random random = new Random();
        JFrame frame = new JFrame();

        MovableWorld world = new MovableWorld();

        frame.add(world);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);       
        // add할때 사이즈가 정해진게 아니라 setVisible할때 정해지는거다
        
        while (world.getCount() < BALL_COUNT) {
            try {
                MovableBall ball = new MovableBall(
                    random.nextInt(FRAME_WIDTH),
                    random.nextInt(FRAME_HEIGHT),
                    10 + random.nextInt(41),
                    colors[random.nextInt(colors.length)]);

                ball.setDx((random.nextInt()) <  0 ?  -(random.nextInt(3) +  1) : random.nextInt(3) + 1);
                ball.setDy((random.nextInt()) <  0 ?  -(random.nextInt(3) +  1) : random.nextInt(3) + 1);
                // random 수가 작을 수록 적게 움직여서 움직임이 부드러워진다(=> frame이 많아져서 그렇다)
                // ball.setDy(random.nextInt(21)+10);
                world.add(ball);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        // 새로 paint하기
        frame.repaint();

        world.run();
    }
}
