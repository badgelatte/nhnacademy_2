@FunctionalInterface
public interface BinaryOp2 {
    int apply(int i, int j);
}

class Math{
    public static int add(int i, int j) {
        return i + j;
    }
}
class Adder implements BinaryOp2 {
    public int apply(int i, int j) {
        return i + j;
    }
}

class Multi implements BinaryOp2 {
    public int apply(int i, int j) {
        return i * j;
    }
}

class Algorithm {
    public static int calc(BinaryOp2 binder, int init, int start, int end, int step) {
        int result = init;
        for (int i = 0; i < end; i+=step) {
            result = binder.apply(result, i);
        }
        return result;
    }

    public static int sigma(int start, int end, int step) {
        // return calc(new Adder(), 1, start, end, step);
        BinaryOp2 binder = new BinaryOp2() {
            public int apply(int i, int j) {
                return i + j;
            }
        };
        return calc(Math::add, 1, start, end, step);
    }
    
    public static int pi(int start, int end, int step) {
        return calc((i, j)-> i * j, 1, start, end, step);
    }
}

