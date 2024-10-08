package com.nhnacademy.exam060401;

public class MovableWorld extends World {
    int moveCount = 0;
    int maxMoveCount = 0;
    int dt = 0;

    public void setDT(int dt) {
        this.dt = dt;
    }

    public int getDT() {
        return dt;
    }

    public void reset() {
        moveCount = 0;
    }

    public void move() {
        for (int i = 0; i < getCount(); i++) {
            Region object = get(i);

            if (object instanceof MovableBall) {
                ((MovableBall) object).move();
            } else if (object instanceof MovableBox) {
                ((MovableBox) object).move();
            }
        }

        repaint();
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        long nextMoveTime = startTime + dt;

        logger.trace("start");
        while ((maxMoveCount == 0) || (moveCount < maxMoveCount)) {
            move();
            moveCount++;
            if (dt != 0) {
                try {
                    long currentTime = System.currentTimeMillis();
                    if (nextMoveTime < currentTime) {
                        nextMoveTime += ((currentTime - nextMoveTime) / dt + 1) * dt;
                    } else {
                        Thread.sleep(nextMoveTime - System.currentTimeMillis());
                        nextMoveTime += dt;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                nextMoveTime = System.currentTimeMillis();
            }
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }

    public void setMaxMoveCount(int maxMoveCount) {
        this.maxMoveCount = maxMoveCount;
    }
}
