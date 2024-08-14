public class Factorial{
    static int factorial(int n) {
        System.out.printf("Called factorial (%d) %n", n);
        if(n == 0) {
            System.out.printf("return factorial(%d) = 1\n", n);
            return 1;
        }
        int result = n * factorial(n-1);
        System.out.printf("return factorial(%d = %d * factorial(%d)) = %d\n",n, n, n-1, result);
        return result;
    }

    public static void main(String[] args) {
        factorial(5);
    }
}