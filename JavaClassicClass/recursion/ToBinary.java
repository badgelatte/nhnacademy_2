public class ToBinary {
    // 10진수 -> 2진수
    static String toBinary(int n) {
        if(n == 0) {
            return "0";
        }

        return toBinary(n/2) + (n %2);
    }

    static void toBinary(StringBuilder sb, int n) {
        if(n > 1){
            toBinary(sb, n/2);
        }
        sb.append(n%2);
    }

    static String toBinary_ByMe(int n) {
        String result = "";
        if(n <= 1) {
            result += n%2;
            return result;
        } else {
            result = toBinary(n/2);
            result += n%2;
            return result;
        }
        // return result;
    }

    static final char[] digits = {
        '0','1','2','3',
        '4','5','6','7',
        '8','9', 'a','b',
        'c','d','e','f'};

    // 10진수 -> 16진수
    static void toConversion(StringBuilder sb, int n) {
        if(n > 15) {
            toConversion(sb, n/16);
        }
        sb.append(digits[n%16]);
    }

    // 10진수 -> base진수(내가 원하는 진수로 가능(ex. 2,4,8,16))
    static void toConversion(StringBuilder sb, int n, int base) {
        if(n > base-1) {
            toConversion(sb, n/ base, base);
        }
        sb.append(digits[n % base]);
    }


    public static void main(String[] args) {
        int[] values = {1,5,13,1023};
        int base = 16;

        for (int i : values) {
            System.out.printf("toBinary(%d) = %s%n", i, toBinary(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i : values) {
            toBinary(sb, i);
            System.out.printf("toBinary(%d) = %s%n", i, sb.toString());
        }

        sb = sb.delete(0, sb.length());
        for (int i : values) {
            toConversion(sb, i);
            System.out.printf("toConversion(%d) = %s%n", i, sb.toString());
        }

        sb = sb.delete(0, sb.length());
        for (int i : values) {
            toConversion(sb, i, base);
            System.out.printf("toConversion(%d) = %s%n", i, sb.toString());
        }
    }
}
