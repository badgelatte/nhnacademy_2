import java.util.NoSuchElementException;

public class LinkedList {
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
    }

    static String toString(Node list) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        Node p = list;
        while (p != null) {
            if (p != list) {
                sb.append(", ");
            }

            sb.append(p.data);
            p = p.next;
        }

        sb.append("]");
        return sb.toString();
    }

    static int get(Node list, int i) {
        if (list == null) {
            throw new NoSuchElementException();
        }

        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node p = list;
        for (; p != null && i > 0; i--) {
            p = p.next;
        }

        if (p == null) {
            throw new NoSuchElementException();
        }

        return p.data;
    }

    static Node append(Node list, int x) {
        if (list == null) {
            list = new Node(x);
        } else {
            Node p = list;
            while (p.next != null) {
                p = p.next;
            }

            p.next = new Node(x);
        }

        return list;
    }

    static Node append(Node list1, Node list2) {
        Node p = list2;
        while (p != null) {
            list1 = append(list1, p.data);
            p = p.next;
        }

        return list1;
    }

    static Node insert(Node list, int i, int x) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (i == 0) {
            list = new Node(x, list);
        } else if (i == 1) {
            if (list == null) {
                throw new IndexOutOfBoundsException();
            }

            list.next = new Node(x, list.next);
        } else {
            Node p = list;
            while (p.next != null && i > 1) {
                p = p.next;
                i--;
            }

            if (i > 1) {
                throw new IndexOutOfBoundsException();
            }

            p.next = new Node(x, p.next);
        }

        return list;
    }

    static int size(Node list) {
        Node p = list;
        int size = 0;

        while (p != null) {
            size++;
            p = p.next;
        }

        return size;
    }

    static int sum(Node list) {
        if (list == null) {
            throw new NoSuchElementException();
        }

        int sum = 0;
        Node p = list;
        while (p != null) {
            sum += p.data;
            p = p.next;
        }

        return sum;
    }

    static Node removeLast(Node list) {
        if (list != null) {
            if (list.next == null) {
                list = null;
            } else {
                Node p = list;

                while (p.next.next != null) {
                    p = p.next;
                }

                p.next = null;
            }
        }

        return list;
    }

    static Node copy(Node list) {
        Node newList = null;
        Node p = list;

        while (p != null) {
            newList = append(newList, p.data);
            p = p.next;
        }

        return newList;
    }

    static Node copyOfRange(Node list, int p, int q) {
        if (p < 0 || size(list) < q) {
            throw new IndexOutOfBoundsException();
        }

        Node newList = null;
        for (int i = p; i < q; i++) {
            newList = append(newList, get(list, i));
        }

        return newList;
    }

    static void set(Node list, int i, int x) {
        Node p = list;
        for (; p != null && i > 0; i--) {
            p = p.next;
        }

        if (p == null) {
            throw new IndexOutOfBoundsException();
        }

        p.data = x;
    }

    public static void main(String[] args) {
        Node[] lists = new Node[] {
                null,
                new Node(1),
                new Node(1, new Node(2, new Node(3))) };

        for (Node list : lists) {
            System.out.println(toString(list));
        }

        try {
            System.out.println("get(lists[0], 0) = " + get(lists[0], 0));
        } catch (NoSuchElementException ignore) {
            System.err.println("Errror : NoSuchElementException");
        }
        System.out.println("get(lists[1], 0) = " + get(lists[1], 0));
        System.out.println("get(lists[2], 2) = " + get(lists[2], 2));

        System.out.println("------ Append Data ------");
        int[] appendData = { 1, 2, 3 };
        Node appendList = null;

        for (int data : appendData) {
            appendList = append(appendList, data);
            System.out.println(toString(appendList));
        }

        System.out.println("------ Insert Data ------");
        Node insertList = new Node(1, new Node(3, new Node(5)));
        System.out.println(toString(insertList));

        insert(insertList, 1, 2);
        System.out.println(toString(insertList));

        insert(insertList, 3, 4);
        System.out.println(toString(insertList));

        System.out.println("----- size ------");

        for (Node list : lists) {
            System.out.printf("size(%s) = %d%n", toString(list), size(list));
        }

        System.out.println("----- remove Last -----");
        Node removeList = new Node(1, new Node(2, new Node(3)));

        System.out.println(toString(removeList));
        removeList = removeLast(removeList);
        System.out.println(toString(removeList));
        removeList = removeLast(removeList);
        System.out.println(toString(removeList));
        removeList = removeLast(removeList);
        System.out.println(toString(removeList));

    }
}
