package com.nhnacademy;

public class example9 {
    public static int binarySearch(int[] a, int x) {
        int max;
        int low = 0;
        int high = a.length-1;
        while(low < high) {
            max = (low + high)/2;
            if(a[max] > x) {
                high -= 1;
            } else if(a[max] < x) {
                low+= 1;
            } else {
                return max;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {22,33,44,55,66,77,88,99};
        System.out.println(binarySearch(a, 44));
    }
}
