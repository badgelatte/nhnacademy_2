@FunctionalInterface
public interface BinaryOp {
    int apply(int i, int j);
}

class Test{
    public static int  calc(BinaryOp binder, int i, int j) {
        return binder.apply(i, j);
    }
    public static void main(String[] args) {
        // main 안에서만 사용할 수 있는 객체
        BinaryOp adder = new BinaryOp() {
            public int apply(int i, int j) {
                return i + j;
            }
        };

        int result = calc(adder, 1, 2);
        System.out.println(result);
    }
}