public class Fibonacci {
    static int fibonacci(int n){
        System.out.printf("called fibo(%d)%n", n);
        if(n < 0) {
            throw new IllegalArgumentException();
        } else if(n <= 1){
            System.out.printf("return fibo(%d)%n", n);
            return n;
        } else {
            int result =fibonacci(n-1) + fibonacci(n-2);
            System.out.printf("return fibo(%d) = fibo(%d) + fibo(%d) = %d%n", n, n-1, n-2, result);
            return result;
        }

    }
    
    static int fibonacciIter(int n) {
        int fn_2 = 0;
        int fn_1 = 1;
        int fn =0 ;

        if(n ==0) {
            System.out.printf("return fibo(%d) = %d%n", n, n);
        }
        for (int i = 2; i <= n; i++) {
            fn = fn_1 +fn_2;
            System.out.printf("calc fibo(%d) = fibo(%d) + fibo(%d) = %d%n", i, i-1, i-2, fn);
            
            fn_2 = fn_1;
            fn_1 = fn;
        }

        System.out.printf("return fibo(%d) = %d%n", n, fn);
        return fn;
    }

    public static void main(String[] args) {
        fibonacci(5);
        fibonacciIter(5);
    }
}
