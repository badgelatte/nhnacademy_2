package com.nhnacademy;

import java.awt.Color;

public class BreakableBox extends PaintableBox implements Breakable{

    public BreakableBox(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public BreakableBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
    
}
