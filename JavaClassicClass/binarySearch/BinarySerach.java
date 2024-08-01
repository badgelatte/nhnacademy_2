import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 비교 수행할 수 있도록 Comparable T를 상속하도록 한다
public class BinarySerach<T extends Comparable<T>> {
    public int binarySearch(int[] arrays, int value) {
        int low = 0;
        int high = arrays.length -1;
        int mid = 0;

        while(low <= high) {
            mid = (low + high)/2;
            if(arrays[mid] > value) {
                high = mid -1;
            }
            else if(arrays[mid] < value) {
                low = mid +1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public int listBinarySearch(List<T> list, T value) {
        int low = 0;
        int high = list.size();
        int mid = 0;

        while(low <= high) {
            mid = (low + high)/2;
            if(value.compareTo(list.get(mid)) == -1) {
                high -= 1;
            }
            else if(value.compareTo(list.get(mid)) == 1) {
                low +=1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        BinarySerach<Integer> b = new BinarySerach<>();

        System.out.println(b.listBinarySearch(list, 2));
    }
    
}