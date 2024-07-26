public class AArrayList implements AList {
    private Object[] elements;
    private int index = 0;

    public AArrayList() {
        this.elements = new Object[10];
    }

    public void add(Object item) {
        this.elements[this.index] = item;
        this.index++;
    }

    public Object get(int index) {
        return this.elements[index];
    }

    public int size() {
        return this.index;
    }

    public boolean isEmpty() {
        return this.index == 0 ? true : false;
    }

    public void remove(int index) {
        for (int i = index; i < this.index; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.index--;
    }

    @Override
    public AEnumerator getEnumerator() {
        return new AArrayListEnumerator(this);
    }
}
