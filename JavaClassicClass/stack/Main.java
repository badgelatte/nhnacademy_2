public class Main {
    static void functionA() {
        int value = 1;
        System.out.println("functionA called : value = " + value);
        functionB();
    }
    static void functionB(){
        int value = 2;
        System.out.println("functionB called : value = " + value);
        functionC();
    }
    static void functionC(){
        int value = 3;
        System.out.println("functionC called : value = " + value);
    }

    public static void main(String[] args) {
        functionA();
    }
    
}