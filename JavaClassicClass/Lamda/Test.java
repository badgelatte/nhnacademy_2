interface Func {
    int apply(int i, int j);
}

class Adder implements Func {
    public int apply(int i, int j){
        return i + j;
    }
}

public class Test{
    
    public static int calc(Func f, int i, int j) {
        return f.apply(i,j);
    }

    public static void main(String[] args) {
        int result = calc(new Adder(), 1, 2);
        // 위의 calc에서 Func에 Adder 객체를 넣는 대신 람다식으로 할 수 있다
        int result2 = calc((i, j) -> i + j, 1, 2);

        System.out.println("Adder: " + result + ", Lamda: " + result2);
    }
}