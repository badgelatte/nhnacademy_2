public class ArrayListEnumerator implements AEnumerator {
    AArrayList list;
    int index = 0;

    public ArrayListEnumerator(AArrayList list) {
        this.list = list;
    }

    public boolean hasNext() {
        if (this.index >= this.list.size()) {
            return false;
        }
        else {
            return true;
        }
    }

    public Object next() {
        return this.list.get(this.index++);
    }
}
