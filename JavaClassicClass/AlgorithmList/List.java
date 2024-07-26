public interface List extends Enumerable {
    void add(Object o);
    Object get(int index);
    int size();
    void remove(int index);
    boolean subtract(Object o);
    void clear();
}