import java.util.Arrays;
import java.util.Random;

// 배열 정리하기
public class Example1{
    static void insert(int[] a, int length, int x) {
        int index = 0;
        while(index < length) {
            if(x < a[index]) {
                break;
            }
            
            index++;
        }
        if(length != index) {
            System.out.printf("%d에서 %d개를 %d로 이동시킵니다. \n", index, length-index,index + 1);
        }
        System.arraycopy(a, index, a, index + 1, length - index);
        a[index] = x;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];

        System.out.print(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            int x = random.nextInt(100);
            insert(a, i, x);
            System.out.println(Arrays.toString(a));
        }
        System.out.println(Arrays.toString(a));
    }
}