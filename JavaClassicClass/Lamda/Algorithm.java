// TODO1 @FunctionalInterface -> BinaryOp 작성
// TODO2 Algorithm class calc 메소드 생성
// TODO3 BinaryOp를 구현
// TODO4 Anonymous class 사용
// TODO5 Lamdba Expression 사용
// TODO6 Lamdba method 사용

@FunctionalInterface
interface BinaryOp{
    int apply(int a, int b);
}

class Adder implements BinaryOp {

    @Override
    public int apply(int a, int b) {
        return a + b;
    }
    
}

public class Algorithm {
    public static int calc(BinaryOp b, int i, int j) {
        return b.apply(i, j);
    }

    public static int add(int i, int j) {
        return i+j;
    }

    public static void main(String[] args) {
        Algorithm.calc(new Adder(), 1, 2);
        
    }
}
