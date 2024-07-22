public class BubbleSort {
    public static void sort(int[] arrays) {
        int temp = 0;
        for (int i = 0; i < arrays.length-1; i++) {
            for (int j = 0; j < arrays.length-i-1; j++) {
                if(arrays[j] > arrays[j+1]) {
                    temp = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = temp; 
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ari = {2,3,7,4,5,9,5,3,2};
        sort(ari);
        for (int i : ari) {
            System.out.println(i);
        }
    }
    
}
