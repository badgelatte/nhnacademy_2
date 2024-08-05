package com.nhnacademy;

import java.util.Arrays;

public class example2 {
    public static void main(String[] args) {
        int[]  a = {1,2,3,4,5,6,7,8,9};
        boolean[] b = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] % 2 != 0;
        }

        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * a[i] * Math.PI;
        }

        int[][] d = new int[9][9];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                d[i][j] = (i+1) * (j+1);
            }
        }

        System.out.println("a[] = " + Arrays.toString(a));
        System.out.println("b[] = " + Arrays.toString(b));
        System.out.println("c[] = " + Arrays.toString(c));
        System.out.println("d[][] = " + Arrays.toString(d));
        
        // 예제 2-2 구구단 출력
        for (int i = 0; i < d.length; i++) {
            System.out.println(Arrays.toString(d[i]));
        }
    }
}
