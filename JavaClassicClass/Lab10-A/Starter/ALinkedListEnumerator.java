import java.util.Iterator;

public class ALinkedListEnumerator implements Iterator {
    ALinkedList list;

    public ALinkedListEnumerator(ALinkedList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.head != null;
    }

    @Override
    public Object next() {
        Object data = list.head.data;
        list.head = list.head.nextNode;
        return data;
    }
}
