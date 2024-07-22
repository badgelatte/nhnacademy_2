package com.nhnacademy;

public class Car {
    static int number;
    String maker;
    private int currentSpeed;

    void accelerate(int speed){
        this.currentSpeed = speed;
        // 요건 사용 가능 -> static은 static끼리 사용가능 요건 다른 얘기
        number = 5;
    }

    static void doSomething() {
        // static은 static끼리 사용가능
//        currentSpeed = 5; // 그래서 이거 사용 불가
    }
}

class Test2 {
    public static void main(String[] args) {
        Car.doSomething();  // 이렇게 직접 부르는 경우
        Car.number=5;
        // static으로 선언되어 있을 경우(정적 바인딩) memory에서 다 받아 미리 올라간다
        // 그래서 누구든 간에 사용가능하다
        // static을 안쓰면 dynamic(동적바인딩)


        Car car1 = new Car();
        car1.maker = "Hyundai";
//        car1.currentSpeed = 50;   //private로 변경하면서 직접 설명 불가
        car1.accelerate(50);

        Car car2 = new Car();
        car2.maker = "BMW";
//        car2.currentSpeed = 120;
        car1.accelerate(120);

        Car car3 = new Car();
        car3.maker = "Hyindai";
//        car3.currentSpeed = 50;
        car1.accelerate(50);

        // 클래스는 객체를만들기위한 틀로 위의 3개의 객체는 서로 다른 속성을 가진다
        // 객체의 속성은 클래스의 속성으로 불린 것(ex. String maker, private int currentSpeed)이 된다
        // 객체의 동작은 method가 된다
    }
}
