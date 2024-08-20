package com.nhnacademy;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class World extends JPanel {
    List<Bounded> boundedList;

    public World() {
        super();
        boundedList = new ArrayList<>();
        addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e) {
            }
    
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.printf("Mouse : %d, %d%n", e.getX(), e.getY());
            }
    
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.printf("Mouse clicked%n");
            }

            @Override
            public void mouseMoved(MouseEvent var1) {
                System.out.printf("Mouse : %d, %d%n", var1.getX(), var1.getY());
            }
        });
    }

    

    public void add(Bounded bounded) {
        if (bounded == null) {
            throw new IllegalArgumentException();
        }

        if ((getWidth() < bounded.getMaxX()) || (bounded.getMinX() < 0)
                || (getHeight() < bounded.getMaxY()) || (bounded.getMinY() < 0)) {
            throw new IllegalArgumentException("ball이 world를 벗어 났습니다.");
        }

        boundedList.add(bounded);
    }

    public void remove(Bounded bounded) {
        boundedList.remove(bounded);
    }

    public void remove(int index) {
        boundedList.remove(index);
    }

    public int getCount() {
        return boundedList.size();
    }

    public Bounded get(int index) {
        return boundedList.get(index);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // synchronized(boundedList) {
            for (Bounded bounded : boundedList) {
                if (bounded instanceof Paintable) {
                    ((Paintable) bounded).paint(g);
                }
            }
        // }
    }
}
