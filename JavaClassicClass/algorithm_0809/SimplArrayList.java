import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SimplArrayList implements SimpleList {
    
    class ListIterator implements SimpleListIterator{
        int current = -1;

        public int nowCurrent(){
            return current;
        }

        @Override
        public boolean hasNext() {
            return ((current + 1) < count);
            // innerclass에서 하면 외부, 즉 outerclass에서 어쩌고~
        }

        @Override
        public int next() {
            int data = datas[current + 1];
            current++;

            return data;
        }

        @Override
        public boolean hasPrevious() {
            return 0 <= current;
        }

        @Override
        public int previous() {
            int data = datas[current];
            current--;
            return data;
        }

        @Override
        public void remove() {
            removeAt(current + 1);
        }
        
    }
    static final int DEFAULT_CAPACITY = 10;
    int[] datas;
    int count = 0;

    public SimplArrayList(){
        datas = new int[DEFAULT_CAPACITY];
    }

    public SimplArrayList(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException();
        }
        datas = new int[capacity];
    }

    @Override
    public boolean isEmpty() {
        return count ==0;
    }

    @Override
    public void add(int data) {
        if(count == datas.length) {
            int [] newDatas = Arrays.copyOf(datas, datas.length+DEFAULT_CAPACITY);
            datas = newDatas;
        }
        datas[count++] = data;
    }

    @Override
    public int remove() {
        // if(count < 0) {
        //     throw new NoSuchElementException();
        // }
        // int data = datas[0];
        // System.arraycopy(datas, 1, datas , 0 , count-1);
        // return data;
        return removeAt(0);
    }

    public int removeAt(int index) {
        if(index >= count) {
            throw new IndexOutOfBoundsException();
        }
        int data = datas[index];
        System.arraycopy(datas, index + 1, datas, index, count - index -1);
        --count;
        return data;
    }

    @Override
    public boolean remove(int data) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if(datas[i] == data) {
                index = 1;
                break;
            }
        }
        if( index >= 0) {
            System.arraycopy(datas, index + 1, datas, index, count -index -1);
            --count;

            return true;
        }
        return false;
    }

    @Override
    public boolean contains(int data) {
        for (int i = 0; i < count; i++) {
            if(datas[i] == data) {
                return true;
            }
            
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        if( count > 0) {
            sb.append(datas[0]);
        }
        for (int i = 1; i < count; i++) {
            sb.append(", ");
            sb.append(datas[i]);
        }

        sb.append("]");
        return sb.toString();
    }

    @Override
    public SimpleListIterator iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        SimpleList list = new SimplArrayList();

        System.out.println(list);
        list.add(1);
        System.out.println(list);
        list.add(2);
        System.out.println(list);
        list.add(3);
        System.out.println(list);
        list.add(4);
        System.out.println(list);
        System.out.println("list.size(): " + list.size());
        System.out.println("list.contains(2): " + list.contains(2));
        System.out.println("list.contains(3): " + list.contains(3));
        System.out.println("list.remove(): " + list.remove());
        System.out.println("list: " + list);


        SimpleListIterator iterator1 = list.iterator();
        SimpleListIterator iterator2 = list.iterator();
        System.out.println("iterator.hasNext: " + iterator1.hasNext());
        System.out.println("iterator.next: " + iterator1.next());
        // System.out.println("iterator.next: " + iterator2.next());
        // System.out.println("iterator.next: " + iterator1.next());
        // System.out.println("iterator.next: " + iterator2.next());
        // System.out.println("iterator.next: " + iterator1.next());
        // System.out.println("iterator.next: " + iterator2.next());
        System.out.println("iterator nowCurrent: " + iterator1.nowCurrent());
        System.out.println("iterator1.remove: " + list.remove());
        System.out.println("iterator nowCurrent: " + iterator1.nowCurrent());
        System.out.println("iterator1.next: " + iterator1.next());
        System.out.println("iterator nowCurrent: " + iterator1.nowCurrent());

        List<Integer> listx = new ArrayList<>();
        
        listx.add(1);
        listx.add(2);
        listx.add(3);
        listx.add(4);
        listx.add(5);

        Iterator<Integer> a = listx.iterator();
        System.out.println(a.hasNext());
        System.out.println(a.next());
        a.remove();
        System.out.println(a.next());
        
    }
    
}