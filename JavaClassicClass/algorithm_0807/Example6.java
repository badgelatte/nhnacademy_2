// 자기 참조적 노드를 이용한 LinkeDList 만들기
public class Example6 {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            if(next == null) {
                return data + ", null";
            }
            return data + ", " +  next.data;
        }
    }

    public static void main(String[] args) {
        int[] values = {22,33,44,55,66};
        Node start = new Node(values[0]);
        Node first = start;

        for (int i = 1; i < values.length; i++) {
            start.next = new Node(values[i]);
            start = start.next;
        }
        for (int i = 0; i < values.length; i++) {
            System.out.println(first);
            first = first.next;
        }
    }
}
