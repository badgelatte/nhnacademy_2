public interface List {
    void add(Object o);
    Object get(int index);
    int size();
    void remove(int index);
    boolean subtract(Object o);
    void clear();
}