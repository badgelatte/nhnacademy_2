public interface AList extends Iterable{
    void add(Object item);
    Object get(int index);
    void remove(int index);
    int size();
    boolean isEmpty();
}