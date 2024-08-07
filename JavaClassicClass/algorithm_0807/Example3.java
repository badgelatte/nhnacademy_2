import java.util.Arrays;
import java.util.Random;

// 인덱스 배열을 이용해 각 인덱스별 크기순(올림차순)을 알려주는 인덱스 만들기
public class Example3 {
    static class Node {
        int data;
        int next;

        @Override
        public String toString(){
            return "("+data + ", " + next + ")";
        }
    }

    private static void insert(Node[] nodes, int length, int data) {
        int index = 0;
        while(nodes[index].next != 0 && nodes[nodes[index].next].data < data) {
            index = nodes[index].next;
        }

        nodes[length + 1].data = data;
        nodes[length + 1].next = nodes[index].next;
        nodes[index].next = length +1;
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        Node[] nodes = new Node[10];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < nodes.length - 1; i++) {
            int x = random.nextInt(100);
            insert(nodes, i, x);
            System.out.println(Arrays.toString(nodes));
        }
    }
}
