public class Main {
    private static <T extends Comparable<T>> T search(Node<T> node, T item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        return internalSearch(node, item);
    }
    // 반복할때마다 item이 null인지 확인 하는 과정을 생략하고 맨첨에 1번만 하기 위해 다음과 같이 분리함
    private static <T extends Comparable<T>> T internalSearch(Node<T> node, T item) {
        // Node<T> start = node;
        if(node != null) {
            // -1 : item < node.item / 0 : item == node.item / 1 : item > node.item
            if(item.compareTo(node.item) == 0) {
                return node.item;
            } else if( item.compareTo(node.item) < 0) {
                return search(node.left, item);
            } else {
                return search(node.right, item);
            }
        }
        return null;
        
        // 내가 시도한 실패한 코드
        // while(node != null) {
        //     if(node.item.compareTo(item) == 1){
        //         node = node.left;
        //     } else {
        //         node = node.right;
        //     }
        // }
        // if(node.item.compareTo(item) == -1) {
        //     node.left = new Node(item);
        // }
        // return null;
    }

    public static <T extends Comparable<T>> T searchIter(Node<T> node,T item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        Node<T> p = node;
        while(p!= null) {
            if(item.compareTo(p.item) == 0) {
                return p.item;
            } else if(item.compareTo(p.item)< 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        while(node != null) {
            if(node.item.compareTo(item) == 0) {
                return node.item;
            } else if(node.item.compareTo(item) < 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node<Integer> root = 
        new Node(50, 
            new Node(30, 
                new Node(10, null, new Node(15)), 
                new Node(45)), 
            new Node(60, null, new Node(100)));
        System.out.println("toot: " + root);
        System.out.println(searchIter(root, 45));
        System.out.println(searchIter(root, 30));
    }
}
