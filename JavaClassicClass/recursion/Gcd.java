import java.util.Arrays;

public class Gcd {
    static int gcd(int a, int b){
        System.out.printf("called gcd(%d, %d)%n", a, b);
        if(a==b) {
            System.out.printf("return gcd(%d, %d) = %d%n", a, b,a);
            return a==0?b:a;
        }
        else if(a > b) {
            return gcd(a - b, b);
        }
        else {
            return gcd(a, b - a);
        }
    }

    static int gcd2 (int a, int b){
        System.out.printf("called gcd(%d, %d)%n", a, b);
        // if(a==b) {
        if(a==0 || b==0) {
            System.out.printf("return gcd(%d, %d) = %d%n", a, b,a);
            return a==0?b:a;
        }
        else if(a > b) {
            // return gcd(a - b, b);

            int result = gcd(a % b,b);
            System.out.printf("return gcd(%d, %d) = %d%n", a%b, b, result);
            return result;
        }
        else {
            // return gcd(a, b - a);

            int result = gcd(a,b%a);
            System.out.printf("return gcd(%d, %d) = %d%n", a, b%a, result);
            return result;
        }
    }

    static int gcd3(int a, int b){
        System.out.printf("called gcd(%d, %d)%n", a, b);
        if(a==0) {
            System.out.printf("return gcd(%d, %d) = %d%n", a, b, b);
            return b;
        }
        else if(b==0) {

            System.out.printf("return gcd(%d, %d) = %d%n", a, b, a);
            return a;
        }
        else if(a>b) {
            int result = gcd(a % b,b);
            System.out.printf("return gcd(%d, %d) = %d%n", a%b, b, result);
            return result;
        }
        else {
            int result = gcd(a,b%a);
            System.out.printf("return gcd(%d, %d) = %d%n", a, b%a, result);
            return result;
        }
    }

    static int[] fibos;
    static {
        fibos = new int[50];
        Arrays.fill(fibos, -1);
    }

    // 내가 푼 fibonacci 동적으로 만들기
    static int fibonacciDynamic1(int n) {
        System.out.printf("called fibonacciDynamic(%d)%n", n);
        int result = 0;
        fibos[0] = 0;
        fibos[1] = 1;
        if(fibos[n] == -1) {
            result = fibonacciDynamic(n-1) + fibonacciDynamic(n-2);
            fibos[n] = result;
        }
        else {
            return fibos[n];
        }
        // if(n ==0) {
        //     return 0;
        // }
        // else if(n == 1) {
        //     return 1;
        // }
        // else {
        //     result = fibonacciDynamic(n-1) + fibonacciDynamic(n-2);
        // }


        System.out.printf("return fibonacciDynamic(%d) = %d%n", n, result);
        return result;
    }

    static int fibonacciDynamic(int n) {
        // System.out.printf("called fibonacciDynamic(%d)%n", n);

        // if(fibos[n] != -1) {
        //     System.out.printf("return saved fibonacciDynamic(%d) = %d%n", n, fibos[n]);
        //     return fibos[n];
        // }
        // else {
        //     if(n <= 1) {
        //         fibos[n] = n;
        //     }
        //     else {
        //         fibos[n] = fibonacciDynamic(n-1) + fibonacciDynamic(n-2);
        //     }
        // }
        // return fibos[n];

        // 위를 정리하면 다음과 같다
        if(fibos[n] == -1) {
            if(n <= 1) {
                fibos[n] = n;
            }
            else {
                fibos[n] = fibonacciDynamic(n-1) + fibonacciDynamic(n-2);
            }
        }
        return fibos[n];
    }

    public static void main(String[] args) {
        fibonacciDynamic(6);
        System.out.println(Arrays.toString(fibos));
    //     System.out.printf("gcd (%d, %d) = %d%n", 494, 130, gcd(494, 130));
    //     System.out.printf("gcd (%d, %d) = %d%n", 121, 11, gcd(121, 11));
    }
}