package list;

public class Node {
    Object data;
    Node nextNode;

    public Node(Object data) {
        this.data= data;
    }

    public String toString() {
        return data.toString();
    }
    
}
