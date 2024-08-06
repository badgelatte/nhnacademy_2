import java.util.Arrays;

public class PascalTriangle {
    public static int[][] pascalTriangle(int size) {
        int[][] result = new int[size][];
        for (int i = 0; i < size; i++) {
            int[] array = new int[i+1];
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    array[j] = 1;
                } else {
                    array[j] = result[i-1][j-1] + result[i-1][j];
                }
            }
            result[i] = array;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] result = pascalTriangle(8);
        for (int i = 0; i < result.length; i++) {
            for (int j = result.length-1; j > i; j--) {
                System.out.print("  ");
            }
            System.out.println(Arrays.toString(result[i]));
        }
    }
}