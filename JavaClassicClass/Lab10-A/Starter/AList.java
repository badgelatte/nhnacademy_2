public interface AList extends AEnumerable{
    void add(Object item);
    Object get(int index);
    void remove(int index);
    int size();
    boolean isEmpty();
}