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

    public static void main(String[] args) {
        System.out.printf("gcd (%d, %d) = %d%n", 494, 130, gcd(494, 130));
        System.out.printf("gcd (%d, %d) = %d%n", 121, 11, gcd(121, 11));
    }
}