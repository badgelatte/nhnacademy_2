package com.nhnacademy;

public class BoundedWorld extends MovableWorld{
    public boolean outOfBounds(Ball ball) {
        return ball.getMinX() < getBounds().getMinX()
        || ball.getMinY() < getBounds().getMinY()
        || ball.getMaxX() > getBounds().getMaxX()
        || ball.getMaxY() > getBounds().getMaxY();
    }

    public void bounce(Ball ball) {
        if(ball instanceof MovableBall) {
            if(ball.getMinX() < getBounds().getMinX() 
            || ball.getMaxX() > getBounds().getMaxX()) {
                MovableBall movableBall = ((MovableBall)ball);
                movableBall.setDx(-movableBall.getDx());
            }

            if(ball.getMinY() < getBounds().getMinY() 
            || ball.getMaxY() > getBounds().getMaxY()) {
                MovableBall movableBall = ((MovableBall)ball);
                movableBall.setDy(-movableBall.getDy());
            }
        }
    }

    @Override
    public void move(){
        super.move();
        for (int i = 0; i < getCount(); i++) {
            Ball ball = get(i);
            if (outOfBounds(ball)) {
                bounce(ball);
            }
            for (int j = 0; j < getCount(); j++) {
                if(i == j) {
                    continue;
                }
                Ball other = get(j);
                if(ball.getBounds().intersects(other.getBounds())&& ball instanceof MovableBall) {
                    ((MovableBall)ball).bounce(other);
                }
                // 내가 작성 시도한 거
                // if(ball.getBounds().intersects(other.getBounds())) {
                //     System.out.println("볼이 충돌했습니다.");
                //     if (ball instanceof MovableBall) {
                //         System.out.println("볼 움직임.");
                        
                //         ((MovableBall)ball).setDx(-((MovableBall)ball).getDx());
                //         ((MovableBall)ball).setDy(-((MovableBall)ball).getDy());
                //     }
                //     if (other instanceof MovableBall) {
                //         System.out.println("other 움직임.");
                //         ((MovableBall)other).setDx(-((MovableBall)other).getDx());
                //         ((MovableBall)other).setDy(-((MovableBall)other).getDy());
                //     }
                // }
            }
        }

    }
}
