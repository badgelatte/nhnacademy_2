package com.nhnacademy;

import java.awt.Color;
import java.awt.Frame;
import java.util.Random;

import javax.swing.JFrame;

public class Main_world2 extends Frame {
    static final int FRAME_WIDTH = 500;
    static final int FRAME_HEIGHT = 400;
    static final int BALL_COUNT = 10;
    static final Color[] colors = new Color[]{
        Color.BLUE, Color.BLACK, Color.WHITE, Color.RED, Color.GREEN
    };

    public static void main(String[] args) {
        Random random = new Random();
        JFrame frame = new JFrame();

        World world = new World();

        frame.add(world);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);       
        // add할때 사이즈가 정해진게 아니라 setVisible할때 정해지는거다
        
        while (world.getCount() < BALL_COUNT) {
            try {
                world.add(new PaintableBall(
                    random.nextInt(FRAME_WIDTH),
                    random.nextInt(FRAME_HEIGHT),
                    10 + random.nextInt(41),
                    colors[random.nextInt(colors.length)]));
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        // 새로 paint하기
        frame.repaint();

        
    }
}
