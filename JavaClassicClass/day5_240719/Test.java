public class Test{

    // r1 [0] = 분자 / [1] = 분모
    static public int[] addRational(int[] r1, int[] r2) {
        int numberator = (r1[0] * r2[1]) + (r1[1] * r2[0]);
        int demonimator = r1[1] * r2[1];

        int gcd = gcd(numberator, demonimator);
        return new int[] {numberator/gcd, demonimator/gcd};
    }

    public static int gcd(int i, int j) {
        return j == 0 ? i : gcd(j, i % j);
    }

    public static void main(String[] args) {
        int[] r1 = {1,2};
        int[] r2 = {1,2};
        int[] result = addRational(r1, r2);
    }
}