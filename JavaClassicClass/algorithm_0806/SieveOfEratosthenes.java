import java.util.Arrays;

public class SieveOfEratosthenes {
    public static int[] sieveOfEratosthenes(int size) {
        int[] array = new int[size];
        array[0] = 0;
        for (int i = 2; i <= array.length; i++) {
            array[i-1] = i;
        }

        boolean flag = false;
        int count = 0;
        for (int i = 1; i < size; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] == 0) {
                    flag = true;
                    break;
                }
                if(array[j] == 0) {
                    continue;
                }
                if(array[j] % array[i] == 0) {
                    array[j] = 0;
                }
            }
            if(!flag) {
                count++;
            }
            flag = false;

        }
        int[] result = new int[count-1];
        count = 0;
        for (int i : array) {
            if(i != 0) {
                result[count++] = i;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sieveOfEratosthenes(30)));
    }
}
