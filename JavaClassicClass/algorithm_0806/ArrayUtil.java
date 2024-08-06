import java.util.Arrays;
import java.util.Objects;
import java.util.Random;


public class ArrayUtil{

    public static void check(int[] numbers) {
        if(numbers.length < 0) {
            throw new IllegalArgumentException();
            // throw new ArrayIndexOutOfBoundsException(); 
        }
    }

    /**
     * 
     * @param numbers
     * @return
     * @exception NullPointException 입력된 numbers가 null인 경우
     * @exception IllegalArgumentException 입력된 numbers의 길이가 0인 경우
     */
    public static int min(int[] numbers) {
        check(numbers);
        
        int min = numbers[0];
        for (int i : numbers) {
            if(min > i) {
                min = i;
            }
        }
        return min;
    }

    public static int max(int[] numbers) {
        check(numbers);

        int max = numbers[0];
        for (int i : numbers) {
            if(max < i) {
                max = i;
            }
        }
        return max;
    }

    public static int mean(int[] numbers) {
        check(numbers);
        
        int mean = 0;
        for (int i : numbers) {
            mean += i;
        }
        return mean / numbers.length;
    }

    public static int[] reverse(int[] numbers) {
        check(numbers);
        
        int[] newArray = new int[numbers.length];

        for (int i = numbers.length-1; i >= 0; i--) {
            newArray[numbers.length-i-1] = numbers[i];
        }

        return newArray;

        // int[] result = numbers.clone();
        // for (int i = 0; i < result.length; i++) {
        //     int temp = result[i];
        //     result[i] = result[result.length-1 -i];
        //     result[result.length-1 -i];
        // }
    }

    public static int[] withoutDuplicates(int[] numbers) {
        check(numbers);
        
        boolean flag = false;
        int[] array = new int[numbers.length];
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[j] == numbers[i]){
                    flag = true;
                }
            }
            if(flag == false) {
                array[count++] = numbers[i];
            }
            flag = false;
        }
        return Arrays.copyOfRange(array, 0, count);
        // 어거지로 마추면 이렇게도 사용가능 return concatenate(new int[]{}, numbers);
        /*
        int[] result = new int[numbers.length];
        int count = 0;

        for (int value : numbers) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if(value == result[i]) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                result[count++] = value;
            }
        }
        return Arrays.copyOf(result, count);
         */
        
    }

    public static int[] concatenate(int[] a, int[] b) {
        check(a);
        check(b);
        
        int[] array = new int[a.length+b.length];
        System.arraycopy(a, 0, array, 0, a.length);
        System.arraycopy(b, 0, array, a.length, b.length);
        return array;
        /*
        int[] c= new int[a.length + b.length];

        Arrays.copyOf(a, a.length+b.length);
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }

        int count = a.length;
        for(int value: b) {
            boolean found = false;
            for(int i = 0; i < count; i++) {
                if(value == c[i]) {
                    found = true;
                }
                break;
            }

            if(!found) {
                c[count++] = value;
            }
        }
        return Arrays.copyOf(c, count);
         */

         /*
         int[] c = Arrays.copyOf(a, a.length + b.length);

         for (int i = 0; i < c.length; i++) {
            c[a.length +i ] = b[i];
         }

         // withoutDuplicate 대신 그 내용물을 여기에 넣어도 된다
         return withoutDuplicate(c);


         */

    }

    public static void shuffle(int[] a) {
        check(a);

        for (int i = 0; i < a.length; i++) {
            int random1 = new Random().nextInt(a.length);
            int random2 = (int)(Math.random() * a.length);
            int temp = 0;

            temp = a[random1];
            a[random1] = a[random2];
            a[random2] = temp;
            // System.out.println(random1 + " " + random2);
            // System.out.println(Arrays.toString(a));
        }

        /* 
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int index1 = random.nextInt(a.length);
            int index2 = random.nextInt(a.length);

            int temp = a[index2];
            a[index2] = a[index1];
            a[index1] = temp;
        }
        */
    }

    public static int[] tally(String msg) {
        if(msg.length() <= 0) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[26];
        char[] msgs = msg.toCharArray();

        for (int i = 0; i < msgs.length; i++) {
            msgs[i] = Character.toUpperCase(msgs[i]);
            result[msgs[i]-65]++;
        }
        return result;

        /* 
        int[] results = new int[26];
        String lowerCase = msg.toLowerCase();
        for (int i = 0; i < msgs.length; i++) {
            results[lowerCase.charAt(i)-'a']++;
        }
        */
    }

    public static int[] arraycopy(int[] src, int srcPos, int[] dest, int destPos, int size) {
        check(src);
        check(dest);
        if(srcPos + size > src.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int[] array = dest.clone();

        for (int i = srcPos; i < srcPos+size; i++) {
            if(Objects.equals(src, dest)) {
                dest[destPos++] = array[i];
            } else {
                dest[destPos++] = src[i];
            }
        }
        return dest;
    }

    public static double innerProduct(double[] x, double[] y) {
        int minLen = x.length > y.length ? y.length: x.length;
        double result = 0.0;
        for (int i = 0; i < minLen; i++) {
            result += x[i] * y[i];
        }
        return result;
    }

    public static double[][] outerProduct(double[] x, double[] y) {
        double[][] result = new double[x.length][y.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                result[i][j] = x[i] * y[j];
            }
        }
        return result;
    }

    public static double[][] product(double[][] a, double[][] b) {
        double[][] array = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                double sum = 0.0;
                for (int k = 0; k < b.length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                array[i][j] = sum;
            }
        }
        return array;
    }

    public static double[][] transpose(double[][] a) {
        double[][] array = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                array[j][i] = a[i][j];
            }
        }
        return array;
    }

    public static void main(String[] args) {

        int[] a = {6,2,4,3,7};
        System.out.println(Arrays.toString(a));
        try{
            System.out.println("min: " + min(a));
        } catch(IllegalArgumentException e) {
            System.err.println("numbers의 길이가 0입니다.");
        }
        System.out.println("max: " + max(a));
        System.out.println("mean: " + mean(a));
        
        System.out.println(Arrays.toString(reverse(a)));

        int[] b = {1,2,1,3,1,2,5};
        System.out.println("withoutDuplicates = " + Arrays.toString(b) + 
        " = " + Arrays.toString(withoutDuplicates(b)));

        System.out.println(Arrays.toString(concatenate(a, b)));
        shuffle(a);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(tally("NHNAcademyJavaClass")));

        int[] src = {1, 2, 3, 4, 5, 6};
        int[] dest= new int[10];

        System.out.printf("src = %s%n", Arrays.toString(src));
        System.out.printf("dest1 = %s%n", Arrays.toString(dest));

        arraycopy(src, 0, dest, 0, 6);
        System.out.printf("dest2 = %s%n", Arrays.toString(dest));

        arraycopy(src, 0, dest, 4, 6);
        System.out.printf("dest3 = %s%n", Arrays.toString(dest));

        arraycopy(src, 2, dest, 0, 4);
        System.out.printf("dest4 = %s%n", Arrays.toString(dest));

        arraycopy(dest, 0, dest, 2, 4);
        System.out.printf("dest5 = %s%n", Arrays.toString(dest));

        arraycopy(dest, 2, dest, 0, 8);
        System.out.printf("dest6 = %s%n", Arrays.toString(dest));

        double[] x = {1.1, 2.2, 3.3, 4.4, 5.5};
        // double[] y = {1.1, 2.2, 3.3, 4.4, 5.5};
        double[] y = {6.6, 7.7, 8.8, 9.9};
        System.out.println(innerProduct(x, y));

        double[][] outers = outerProduct(x, y);
        for (int i = 0; i < outers.length; i++) {
            System.out.println(Arrays.toString(outers[i]));
        }
        System.out.println();

        double[][] x1 = {{1.1, 1.2, 1.3},{2.1, 2.2, 2.3},{3.1, 3.2, 3.3}};
        double[][] y1 = {{4.1, 4.2, 4.3},{5.1, 5.2, 5.3},{6.1, 6.2, 6.3}};
        double[][] products = product(x1, y1);
        for (int i = 0; i < products.length; i++) {
            System.out.println(Arrays.toString(products[i]));
        }
        System.out.println();

        double[][] z = {{1.1, 1.2, 1.3},{2.1, 2.2, 2.3}};

        double[][] ta = transpose(z);
        for (int i = 0; i < ta.length; i++) {
            System.out.println(Arrays.toString(ta[i]));
        }
    }
}