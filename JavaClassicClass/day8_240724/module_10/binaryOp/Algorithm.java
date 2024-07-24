package module_10.binaryOp;

public class Algorithm {
    public static int sigma(int start, int end, int step) {
        return calc(new Adder(), 0, start, end, step);
    }

    public static int pi(int start, int end, int step) {
        return calc(new Multiplier(), 1, start, end, step);
    }

    private static int calc(BinaryOp binder, int init, int start, int end, int step) {
        int result = init;
        for (int i = start; i <= end; i += step) {
            result = binder.apply(result, i);
        }
        return result;
    }
}

class Test_Algorithm {
    public static void main(String[] args) {
        System.out.println(Algorithm.sigma(1, 10, 1));
        System.out.println(Algorithm.pi(1, 10, 1));
    }
}
