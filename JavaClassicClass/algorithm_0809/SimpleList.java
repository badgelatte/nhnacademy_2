
public interface SimpleList {
    boolean isEmpty();
    void add(int data);
    int remove();
    boolean remove(int data);
    boolean contains(int data);
    int  size();
    SimpleListIterator iterator();
}
