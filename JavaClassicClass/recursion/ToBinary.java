public class ToBinary {
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
    public static void main(String[] args) {
        int[] values = {1,5,13,1023};

        for (int i : values) {
            System.out.printf("toBinary(%d) = %s%n", i, toBinary(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i : values) {
            toBinary(sb, i);
            System.out.printf("toBinary(%d) = %s%n", i, sb.toString());
        }
    }
}
