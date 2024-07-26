package list;

public class ArrayList implements List{
    private Object[] elements;
    private int index;

    public ArrayList(){
        this.elements = new Object[5];
    }
    
    public ArrayList(ArrayList list){
        this.elements = list.elements.clone();
    }

    public void add(Object o){
        this.elements[this.index] = o;
        this.index++;
    }

    public Object get(int index) {
        return this.elements[index];
        // 선생님은 다음과 같이 작성하였지만 이렇게 작성하면 index 받을 필요 없습니다
        // return this.elements[this.index--];
    }

    public int size() {
        return this.index;
    }


}