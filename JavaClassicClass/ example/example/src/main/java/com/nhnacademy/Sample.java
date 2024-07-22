package com.nhnacademy;

public class Sample {
    /*int i;
    Sample sample;

    public static void main(String[] args) {
        Sample sample = new Sample();
        System.out.println(sample.i);
        System.out.println(sample.sample);
        // 지역 변수는 초기화 해야하지만 객체 변수는 기본값이 들어간다

        System.out.println(sample.sample.i);
    }*/

    private int no;
    private String name;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;   // 여기서 사용한게 this다
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sample getMe() {
        return this;
        // 나를 반환하는 method
    }

    public Sample getAnotherMe() {
        Sample s = new Sample();
        s.setName(this.name);
        s.setNo(this.no);
        return s;
    }

    public static void main(String[] args) {
        Sample s = new Sample();
        Sample s2 = s.getAnotherMe();  // s와 s2는 같은 것이다

        s.setName("Celine");

        System.out.println(s2.getName());

    }
}
