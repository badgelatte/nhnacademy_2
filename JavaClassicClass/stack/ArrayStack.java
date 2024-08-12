public class ArrayStack implements Stack{
    int[] array;
    static final int DEFAULT_INCREMENT_SIZE = 10;
    int top = -1;
    int how;

    public ArrayStack() {
        this(DEFAULT_INCREMENT_SIZE);
    }
    public ArrayStack(int capacity) {
        this(capacity, DEFAULT_INCREMENT_SIZE);
    }

    public ArrayStack(int capacity, int how) {
        this.how = how;
        array = new int[capacity];
    }

    @Override
    public void push(int elemnent) {
        if((top + 1) >= array.length) {
            // array = Arrays.copyOf(array, array.length + incrementSize);
            int[] newArr = new int[array.length + how];
            System.arraycopy(array, 0, newArr, 0, array.length);
            array = newArr;
        }
        array[++top] = elemnent;
    }

    @Override
    public int pop() {
        if (top < 0) {
            throw new StackEmptyException();
        }
        return array[top--];
    }

    @Override
    public int peek() {
        return array[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
    
        stack.push(1);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(2);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(3);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(4);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.push(5);
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
        System.out.println("top : " + stack.peek() + ", size : " + stack.size());
        stack.pop();
    }
}
