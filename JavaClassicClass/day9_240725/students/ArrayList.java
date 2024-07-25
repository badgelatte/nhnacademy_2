package students;

public class ArrayList {
    private Object[] items;
    private int index = 0;

    public ArrayList() {
        items = new Object[5];
    }

    public void add(Object item) {
        items[index++] = item;
    }

    public Object get(int index) {
        return items[index--];
    }
}
