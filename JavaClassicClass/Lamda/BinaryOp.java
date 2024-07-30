@FunctionalInterface
public interface BinaryOp {
    int apply(int i, int j);
}

class Math{
    public static int addTwoInt(int i, int j) {
        return i + j;
    }
}

class Algorithm {
    public static int calc(BinaryOp binder, int i, int j) {
        return binder.apply(i, j);
    }
}

class Test3 {
    public static void main(String[] args) {
        // Algorithm.calc((x,y)-> x+y, 1, 2);
        Algorithm.calc(Math::addTwoInt, 1, 2);
    }
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