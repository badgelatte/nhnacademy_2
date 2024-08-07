import java.util.Arrays;
import java.util.Random;

// 간단한 Node 클래스를 이용하여 LinkedNode 만들기
public class Example4 {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node start = new Node(0);
        Node p = start;

        p.next = new Node(13);
        p = p.next;
    }
}
