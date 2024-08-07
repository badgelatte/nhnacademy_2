public class Example7 {
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
    
    // 리스트 맨 앞에 삽입하기 
    static Node insert(Node start, int data) {
        Node node = new Node(data);
        node.next = start;
        start = node;
        return start;
    }

    // 순서 찾아서 넣기
    static void insertSequence(Node start, int data) {
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

        /*
        if(start == null || (data < start.data)) {
            start = new Node(data);
        }else {
            Node p = start;
            while(p.next != null) {
                p = p.next;
            }
            p.next = new Node(data, p.next);
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

        insertSequence(start, 45);
        for (p = start; p != null; p = p.next) {
            System.out.println(p.data);
        }
        System.out.println();

        start = insert(start, 40);

        for (p = start; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }
}
