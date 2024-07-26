import java.util.Iterator;

public class AArrayListEnumerator implements Iterator {
    AArrayList list;
    int index = 0;

    public AArrayListEnumerator(AArrayList list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return (this.index >= list.size()) ? false : true;
    }

    @Override
    public Object next() {
        return this.list.get(this.index++);
    }
}
