package module_10;

public interface List {
	void add(Object item);
	Object get(int index);
}

class ArrayList implements List {
    private Object[] items;
    private int index = 0;

    public ArrayList() {
        items = new Object[5];
    }

    @Override
    public void add(Object item) {
        items[index++] = item;
    }

    @Override
    public Object get(int index) {
        return items[index--];
    }
}

class Test {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(1);
		list.add("Celine");
		
		System.out.println(list.get(1));
	}
}