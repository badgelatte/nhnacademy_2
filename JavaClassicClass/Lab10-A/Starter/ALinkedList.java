import java.util.Iterator;

class ANode {
    Object data;
    ANode nextNode;

    public ANode(Object data) {
        this.data = data;
    }
}

public class ALinkedList implements AList {
    ANode head;
    int size;

    public ALinkedList() {}

    public void add(Object item) {
        ANode node = new ANode(item);
        if (this.head == null) {
            this.head = node;
        }
        else {
            while (head.nextNode != null) {
                head = head.nextNode;
            }
            head.nextNode = node;
        }
        this.size++;
    }

    public Object get(int index) {
        ANode current = this.head;
        for (int i = 0; i < index; i++) {
            current = head.nextNode;
        }
        return current.data;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null ? true : false;
    }

    public void remove(int index) {
        throw new RuntimeException("not implement yet");
    }

    @Override
    public Iterator iterator() {
        return new ALinkedListEnumerator(this);
    }
}
