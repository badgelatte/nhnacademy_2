// 특정 node 삭제하기
public class Example8 {
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
    
    static Node insert(Node start, int data) {
        Node result = start;
        Node node = new Node(data);
        while(start.data < data) {
            if(start.next != null  && start.next.data > data) {
                node.next = start.next;
                start.next = node;
            } else if(start.next == null) {
                start.next = node;
            }
            start = start.next;
        }
        return result;
    }

    static Node delete(Node start, int data) {
        Node p = start;
        if(start.data == data) {
            start = start.next;
            return start;
        }

        while (p.next != null) {
            if(p.next.data == data) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return start;

        /*
        if(start == null) {
            start = start.next;
        } else {
            Node p = start;
            while((p.next != null)&& (p.next.data != data)) {
                p = p.next;
            }
            if(p.next != null) {
                p.next = p.next.next;
            }
        }
        return start;
        */
    }

    public static void main(String[] args) {
        int[] values = {22,33,44,55,66};
        Node start = new Node(values[0]);
        Node p = start;

        for (int i = 1; i < values.length; i++) {
            p.next = new Node(values[i]);
            p = p.next;
        }

        start = insert(start, 40);

        for (p = start; p != null; p = p.next) {
            System.out.println(p.data);
        }
        System.out.println();

        start = delete(start, 40);

        for (p = start; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }
}
