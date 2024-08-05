import java.util.Iterator;
import java.util.Objects;

import list.ArrayList;

public class LinkedList {
    Node head;
    int size;

    public LinkedList() {
        head = new Node();
    }

    public void add(int data) {
        if(head == null) {
            head = new Node(data, null);
            size++;
            return;
        }

        Node node = head;
        while(node.getNextNode() == null) {
            node = node.getNextNode();
        }
        Node newNode = new Node(data, null);
        node.setNextNode(newNode);
    }

    public int get(int index) {
        Node node = head;
        while(index-- > 0) {
            node = node.getNextNode();
        }
        return node.getData();
    }

    public int size() {
        return size;
    }

    public int remove(int index){
        Node node = head;
        while(index-- > 1) {
            node = node.getNextNode();
        }

        Node newNode = node.getNextNode().getNextNode();
        if(newNode == null) {
            node.setNextNode(null);
            size--;
            return null;
        }
        node.setNextNode(newNode);
        size--;
        return newNode.getData();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        head = null;
    }

}

class Node {
    int data;
    Node nextNode;
    
    public Node (int data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
    

}

// List 상속받는 class들
class Test{
    public static void saveString(String s, List<String> list) {
        list.add(s);
    }
    public static void main(String[] args) {

        // ArrayList와 LinkedList 모두 List를 상속하기 때문에 saveString이 사용 가능하다
        // List<String> list = new ArrayList();
        List<String> list = new LinkedList();

        saveString("Celine", list);

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for(Iterator i: list) {
            System.out.println(i);
        }
    }
}