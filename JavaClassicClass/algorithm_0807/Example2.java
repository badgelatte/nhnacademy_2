import java.util.Arrays;
import java.util.Random;

// array copy 만들기
public class Example2 {
    
    private static void insert(int[] a, int[] k, int length, int x) {
        int i = 0;
        while (i < length) {
            if(x < a[k[i]]) {
                break;
            }
            i++;
        }
        if(length != i) {
            System.out.printf("%d에서 %d개를 %d로 이동시킵니다.\n", i, length-i, i+ 1);
        }
        System.arraycopy(k, i, k, i+1, length - i);
        a[length] = x;
        k[i] = length;
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        int[] k = new int[10];

        System.out.print(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            int x = random.nextInt(100);
            insert(a, k, i, x);
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(k));

    }
}
