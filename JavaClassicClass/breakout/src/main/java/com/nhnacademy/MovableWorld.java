package com.nhnacademy;

/* 
 * 수작업 그림 작업 중 frame 역할을 맡음
 */
public class MovableWorld extends World{
    int moveCount;
    int maxMoveCount;
    
    public MovableWorld(){
        this(0, 0);
    }
    
    public MovableWorld(int moveCount, int maxMoveCount){
        this.moveCount = moveCount;
        this.maxMoveCount = maxMoveCount;
    }
    
    public int getMoveCount(){
        return moveCount;
    }

    public int getMaxMoveCount(){
        return maxMoveCount;
    }

    public void setMaxMoveCount(int count){
        maxMoveCount = count;
    }

    public void reset(){
        moveCount = 0;
    }

    public void move(){
        for (int i = 0; i < getCount(); i++) {
            Ball ball = get(i);
            if(ball instanceof MovableBall) {
                ((MovableBall)ball).move();
            }
        }
        moveCount++;
        repaint();

        // 내가 만든것
        // if(maxMoveCount == 0 || maxMoveCount > moveCount) {
        //     for (Ball ball : ballList) {
        //         if(ball instanceof MovableBall) {
        //             ((MovableBall)ball).move();
        //         }
        //     }
        //     repaint();
        //     moveCount++;
        // }
    }

    public void run(){
        while (maxMoveCount == 0 || moveCount < maxMoveCount) {
            move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // 내가 만든 것
        // while (maxMoveCount > moveCount++) {
        //     move();
        // }
        // if(maxMoveCount == 0) {
        //     while (true) {
        //         move();
        //     }
        // }
    }
}
