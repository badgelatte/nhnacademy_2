package hash_0813;

import java.util.Arrays;

public class Exam6_4_6_1 {
    private static final int MASK = 0x7FFFFFFF; // 2^32-1
    private static final int CAPACITY = 11;
    private static int size = 0;
    private static boolean[] used = new boolean[CAPACITY];

    public static void main(String[] args) {
        printHash("Rad");
        printHash("Uhr");
        printHash("Ohr");
        printHash("Tor");
        printHash("Hut");
        printHash("Tag");
        printHash("Eis");
        printHash("Ast");
        printHash("Zug");
        printHash("Hof");
        printHash("Mal");

        size = 0;
        Arrays.fill(used, false);
        printHash("Mal");
        printHash("Hof");
        printHash("Zug");
        printHash("Ast");
        printHash("Tag");
        printHash("Hut");
        printHash("Eis");
        printHash("Tor");
        printHash("Ohr");
        printHash("Uhr");
        printHash("Rad");
    }

    private static void printHash(String word) {
        System.out.printf("hash(%s) = %d, load = %d%%%n",
                word, hash(word), 100 * size / CAPACITY);
    }

    private static int hash(Object object) {
        int index = object.hashCode() % CAPACITY;
        int startIndex = index;

        while (used[index]) {   // 현재 자리를 사용하면 다음 자리에 찾아가기 위해
            System.out.printf("%d, ", index);
            index = (index + 1) % CAPACITY;
            if(index == startIndex) {
                // throw new NotEnoughMemoryException();
                throw new RuntimeException("더이상 공간이 없습니다");
            }
        }
        ++size;
        used[index] = true;
        return index;
    }
}
