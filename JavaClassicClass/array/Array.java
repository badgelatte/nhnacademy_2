public class Array {
    public static void main(String[] args) {
        // 선언
        int[] numbers;
        // 다차원 배열
        int[][] doubleNumbers;
        boolean[] bools;
        double[] doubles;
        Object[] objects;

        // 정의 하기전에 할당하면 오류 남
        // numbers[1] = 1;

        // 정의
        numbers = new int[5];
        bools = new boolean[3];
        doubles = new double[4];
        objects = new Object[10];
        doubleNumbers = new int[3][4];

        short sindex = 1;
        int index = 1;
        long lindex = 1;

        // long인 lindex를 []안에 넣으면 오류 남
        doubleNumbers[index][sindex] = 1;

        // 이렇게 사용하고부터 고정됨
        System.out.println("numbers.length: " + numbers.length);
        System.out.println("numbers.length: " + bools.length);
        System.out.println("numbers.length: " + doubles.length);
        System.out.println("numbers.length: " + objects.length);
    }
}