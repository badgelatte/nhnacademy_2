public class ArrayListEnumerator implements Enumerator {
    ArrayList list;
    int index = 0;

    public ArrayListEnumerator(ArrayList list) {
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
