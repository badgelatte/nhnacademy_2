import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<K extends Comparable<K>, V extends Comparable<V>>{
    class Node<T> {
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

        public void addLeft(Node<T> left) {
            this.left = left;
        }

        public void addRight(Node<T> right) {
            this.right = right;
        }

        public String toString(){            
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(left != null) {
                sb.append(left.toString());
            }else {
                sb.append("_");
            }
            sb.append(",");
            sb.append(item.toString());
            sb.append(",");
            if(right != null) {
                sb.append(right.toString());
            } else {
                sb.append("_");
            }
            sb.append("]");
            return sb.toString();
        }
    }
    
    class Entry<K extends Comparable<K>,V extends Comparable<V>>{
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(key + ", " + value);
            sb.append(")");
            return sb.toString();
        }
    }

    Node<Entry<K,V>> root;
    int size = 0;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Entry<K, V> entry){
        root = new Node<>(entry);
    }

    public void insert(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        if(root == null) {
            root = new Node<>(entry);
            return;
        }
        add(root, entry);
    }

    private void add(Node<Entry<K,V>> root, Entry<K,V> entry) {
        K pKey = root.item.getKey();
        if(pKey.compareTo(entry.getKey()) == 0) {
            root.item.setValue(entry.getValue());
            return;
        }else if(pKey.compareTo(entry.getKey()) > 0) {
            if(root.left == null) {
                root.left = new Node<>(entry);
                size++;
                return;
            }
            add(root.left, entry);
        }else {
            if(root.right == null) {
                root.right = new Node<>(entry);
                size++;
                return ;
            }
            add(root.right, entry);
        }
    }

    public String toString(){
        return root.toString();
    }

    public int getKeySize(){
        return size;
    }

    public int getValueSize() {
        return size;
    }

    public Entry<K,V> delete(Node<Entry<K, V>> node, K key) {
        if(node == null) {
            return null;
        } 
        while(node != null) {
            if(node.item.getKey().compareTo(key) == 0) {
                Entry<K,V> result = node.item;

                if(node.left != null && node.right != null) {
                    Node<Entry<K,V>> nodeRight = node.right;
                    node = node.left;
                    while(node.right != null) {
                        node = node.right;
                    }
                    node.right = nodeRight;
                    size--;
                    
                } else if(node.left == null) {
                    node = node.left;
                    size--;
    
                } else if(node.right == null) {
                    size--;
                    node = node.right;
                } else {
                    size--;
                    node = null;
                }
                return result;
            }
            else if(node.item.getKey().compareTo(key) > 0){
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
        
    }

    public V get(K key) {
        Node<Entry<K,V>> start = root;
        while(start!= null) {
            if(start.item.getKey().compareTo(key) == 0) {
                return start.item.getValue();
            }
            else if(start.item.getKey().compareTo(key) > 0) {
                start = start.left;
            } else {
                start = start.right;
            }
        }
        return null;
    }

    public boolean contains(V value) {
        Node<Entry<K,V>> start = root;
        while(start!= null) {
            if(start.item.getValue().compareTo(value) == 0) {
                return true;
            }
            else if(start.item.getValue().compareTo(value) > 0) {
                start = start.left;
            } else {
                start = start.right;
            }
        }
        return false;
    }

    // 깊이 우선 탐색
    public List<Entry<K,V>> toDFS(boolean reverse) {
        List<Entry<K,V>> list = new LinkedList<>();
        toDFS(list, root, reverse);
        return list;
    }

    private void toDFS(List<Entry<K,V>> list, Node<Entry<K,V>> root, boolean reverse) {
        if(root!=null) {
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

    public List<Entry<K,V>> toBFS(boolean reverse) {
        List<Entry<K,V>> list = new LinkedList<>();
        Queue<Node<Entry<K,V>>> queue = new LinkedList<>();

        if(root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            if(!reverse) {
                Node<Entry<K,V>> node = queue.poll();
                if(node.left!= null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.item);
            } else {
                Node<Entry<K,V>> node = queue.poll();
                if(node.right!= null) {
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

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        bst.insert(5,"five");
        bst.insert(3,"three");
        bst.insert(9,"nine");
        bst.insert(6,"six");
        bst.insert(4,"four");
        bst.insert(7,"seven");
        bst.insert(1, "one");
        bst.insert(8,"eight");
        bst.insert(2,"two");
        System.out.println(bst.getKeySize());
        System.out.println(bst.getValueSize());
        System.out.println(bst.toBFS(false));
        System.out.println(bst.toBFS(true));
        System.out.println(bst.toDFS(false));
        System.out.println(bst.toDFS(true));
    }

}