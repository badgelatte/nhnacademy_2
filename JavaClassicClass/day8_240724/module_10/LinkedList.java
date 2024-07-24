package module_10;

class Node {
    Object data;
    Node nextNode;

    public Node(Object data) {
        this.data= data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

public class LinkedList implements List{
    Node node;
    int size = 0;

    @Override
    public void add(Object item) {
        if(this.node == null) {
            this.node = new Node(item);
            size++;
        }
        else {
            Node currentNode = this.node;
            while(currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = new Node(item);
            size++;
        }
    }

    @Override
    public Object get(int index) {
        if(index > size) return "Index is over than LinkedList size";
        int count = 0;
        System.out.println("currentNode"+node.toString());
        while (count++ < index) {
            /* 
            * null 참조 변수를 언박싱하면 NPE가 발생합니다
            * ex
            * Integer a = null;
            * int b = a;  // throws NPE.
            * 출처: https://stackoverflow.com/questions/30014811/assign-null-to-null-in-java 
            
            if(node == null) {
                return "there isn't data";
            }
            */
            node = node.nextNode;
        }

        size--;
        return node;
    }
    
}

class Test_LinkedList{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add("ee");
        list.add('c');

        System.out.println(list.get(4).toString());
    }
}