public class ArrayList implements List{
    Object[] array;
    int size = 0;

    public ArrayList(){
        array = new Object[10];
    }
    public ArrayList(int size){
        array = new Object[size];
    }

    @Override
    public void add(Object o) {
        array[size++] = o;
    }

    @Override
    public Object get(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        array[index] = null;
        for (int i = index; i < size-1; i++) {
            array[i] = array[i + 1];
        }
    }

    @Override
    public boolean subtract(Object o) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[array.length];
    }

    public Enumerator getEnumerator(){
        return new ArrayListEnumerator(this);
    }
}
