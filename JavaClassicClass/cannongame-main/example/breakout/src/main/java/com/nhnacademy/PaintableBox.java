package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBox extends Box implements Paintable{
    public static final Color DEFAULT_COLOR = Color.BLUE;
    Color color;

    public PaintableBox(int x, int y, int width, int height) {
        this(x, y, width, height, DEFAULT_COLOR);
    }

    public PaintableBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }
    
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(getMinX(), getMinY(), getWidth(), getHeight());
    }
}
