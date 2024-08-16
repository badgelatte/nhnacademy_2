import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    // 깊이 우선 탐색
    public List<V> toDFS(boolean reverse){
        List<V> list = new LinkedList<>();
        toDFS(list, root, reverse);
        return list;
    }

    public void toDFS(List<V> list, Node<V> root, boolean reverse) {
        if (root!=null) {
            if(!reverse) {
                if(root.left != null) {
                    toDFS(list, root.left, reverse);
                }
                list.add(root.item);
                if(root.right != null) {
                    toDFS(list, root.right, reverse);
                }
            } else {
                if(root.right != null) {
                    toDFS(list, root.right, reverse);
                }
                list.add(root.item);
                if(root.left != null) {
                    toDFS(list, root.left, reverse);
                }
            }
        }
    }

    // 넓이 우선 탐색
    public List<V> toBFS(boolean reverse){
        List<V> list = new LinkedList<>();
        Queue<Node<V>> queue = new LinkedList<>();

        if(root != null) {
            queue.add(root);
        }
        
        while(!queue.isEmpty()) {
            if(!reverse) {
                Node<V> node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.item);
            } else {
                Node<V> node = queue.poll();
                if(node.right != null) {
                    queue.add(node.right);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                list.add(node.item);
            }
        }

        return list;
    }
    

    @Override
    public String toString(){
        return root.toString();
    }
}
