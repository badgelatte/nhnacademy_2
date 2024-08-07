// 특정 node 삭제하기

import java.util.Random;

public class Example_final {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
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
        if(start == null) {
            start = new Node(data);
            return start;
        }
        Node startPoint = start;
        Node target = new Node(data);
        if(start.data > data) {
            target.next = start;
            start = target;
            return start;
        }

        while (start.next != null) {
            if(start.next.data > data) {
                target.next = start.next;
                start.next = target;
                return startPoint;
            }
            start = start.next;
        }
        start.next = target;
        return startPoint;

        /*
        // 선생님 코드
        if(start == null || data < start.data) {
            start = new Node(data);
        } else {
            Node p = start;
            while(p.next != null && p.next.data < data) {
                p = p.next;
            }

            p.next = new Node(data, p.next);
        }
        return start;
        */
    }

    static Node delete(Node start, int data) {
        Node p = start;
        if(start.data == data) {
            start = start.next;
            return start;
        }

        while (p != null && p.next != null) {
            if(p.data > data) {
                break;
            }
            if(p.next.data == data) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return start;

        /*
        // 선생님 코드
        if(start != null) {
            if(start.data == data) {
                start = start.next;
            } else {
                Node p = start;
                while(p.next != null) {
                    if(p.next.data == data) {
                        p.next = p.next.next;
                        break;
                    }
                    p = p.next;
                }
            }
        }
        return start;
        */
    }

    static void print(Node node) {
        /*
        // 선생님 코드
        System.out.print("[ ");
        if(node != null) {
            Node p = node;
            while(p!= null) {
                System.out.print(p.data + " ");
                p = p.next;
            }
        }
        System.out.println("]");
        */

        while(node.next != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    public static void main2(String[] args) {
        Random random = new Random();

        Node start = null;

        for (int i = 0; i < 10; i++) {
            int target = random.nextInt(20);
            start = insert(start, target);
            System.out.println("insert: " + target);
            print(start);
        }
        System.out.println();
        
        for (int i = 0; i < 10; i++) {
            int target = random.nextInt(20);
            System.out.println("Delete: " + target);
            start = delete(start, target);
            print(start);
        }
    }

    public static void main(String[] args) {
        Node start1 = null;
        Node start2 = new Node(10);
        Node start3 = new Node(10, new Node(20));

        print(start1);
        print(start2);
        print(start3);

        int[] data = {1,5,2,3};
        Node start4= null;
        for (int i = 0; i < data.length; i++) {
            start4 = insert(start4, data[i]);
            print(start4);
        }

        start4 = delete(start4, 3);
        print(start4);
        start4 = delete(start4, 5);
        print(start4);
        start4 = delete(start4, 1);
        print(start4);
        start4 = delete(start4, 2);
    }
}
