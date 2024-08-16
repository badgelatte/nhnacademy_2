public class BinarySearchTree<V extends Comparable<V>> {
    class Node<T extends Comparable<T>> {
        T item;
        Node<T> left;
        Node<T> right;

        public Node(T item) {
            this.item = item;
        }

        public Node(T item, Node<T> left, Node<T> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            
            sb.append("[");
            if(left != null) {
                sb.append(left.toString());
            } else {
                sb.append("_");
            }
            sb.append(",");
            sb.append(item);
            sb.append(",");

            if(right!= null) {
                sb.append(right.toString());
            } else {
                sb.append("_");
            }

            sb.append("]");

            return sb.toString();
        }
    }

    Node<V> root;
    public void insert(V item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }
        if(root == null) {
            root = new Node<>(item);
        }  else {
            Node<V> p = root;
            boolean inserted = false;
            while(!inserted && item.compareTo(p.item) != 0) {
                if(item.compareTo(p.item) < 0) {
                    if(p.left == null){
                        p.left = new Node<>(item);
                        inserted = true;
                    } else {
                        p = p.left;
                    }
                } else {
                    if(p.right == null) {
                        p.right = new Node<>(item);
                        inserted = true;
                    } else {
                        p = p.right;
                    }
                }
            }
        }
        //내가 만들다 실패한 코드
        // Node<V> p = root;
        // while(root!= null) {
        //     if(item.compareTo(p.item) < 0) {
        //         p = p.left;
        //     } else if(item.compareTo(p.item) > 0) {
        //         p = p.right;
        //     }
        // }
        // if(item.compareTo(p.item) < 0) {
        //     if(p.left == null) {
        //         p.left = new Node(item);
        //     }
        // }

    }
    public V search(V item) {
        if(item == null) {
            throw new IllegalArgumentException();
        }

        Node<V> p = root;
        while(p != null) {
            if(item.compareTo(p.item) ==0) {
                return p.item;
            } else if(item.compareTo(p.item) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return root.toString();
    }
}
