class Node<V extends Comparable<V>> {
    V item;
    Node<V> left;
    Node<V> right;

    public Node(V item) {
        this.item = item;
        this.left = null;
        this.right = null;
    }

    public Node(V item, Node<V> left, Node<V> right) {
        this.item = item;
        this.left = left;
        this.right = right;
    }

    public V search(V item) {
        if(item != null) {
            if(item.compareTo(this.item) == 0) {
                return this.item;
            } else if(item.compareTo(this.item) < 0) {
                if(left != null) {
                    return left.search(item);
                }
            } else if(right != null) {  
            // item과 비교해서 ==0과 < 0이 아닌 조건 중에 right != null이므로 굳이 >0을 안해도 된다
                return right.search(item);
            }
        }
        return null;
    } 

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if(left!= null) {
            sb.append(left.toString());
        } else {
            sb.append("null");
        }
        sb.append(",");
        sb.append(item);
        sb.append(",");

        if(right!= null) {
            sb.append(right.toString());
        } else {
            sb.append("null");
        }

        sb.append("]");

        return sb.toString();
    }
}
