@FunctionalInterface
public interface BinaryOp3 {
    int apply(int i, int j);
}

class Math{
    public static int add(int i, int j) {
        return i + j;
    }
}

// class Adder implements Function<Integer, Integer> {
//     public Integer apply(Integer i, Integer j) {
//         return i + j;
//     }
// }

class Algorithm {
    public static int calc(BinaryOp3 binder, int init, int start, int end, int step) {
        int result = init;
        for (int i = 0; i < end; i+=step) {
            result = binder.apply(result, i);
        }
        return result;
    }

    public static int sigma(int start, int end, int step) {
        // return calc(Math::add, 1, start, end, step);

        //Anonymus class
        // BinaryOp3 b = new BinaryOp3() {
        //     public int apply(int i, int j) {
        //         return i + j;
        //     }
        // };
        // return calc(b, 1, start, end, step);

        // Lambda Expression
        // return calc((i,j)->i + j, 0 , start, end, step);

        //method Reference
        return calc(Math::add, 0, start, end, step);
    }
    
    public static int pi(int start, int end, int step) {
        return calc((i, j)-> i * j, 1, start, end, step);
    }

    
}

