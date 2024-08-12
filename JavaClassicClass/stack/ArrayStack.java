public class ArrayStack implements Stack{
    int[] array;
    static final int DEFAULT_SIZE = 10;
    int top = -1;

    public ArrayStack() {
        this(DEFAULT_SIZE);
    }
    public ArrayStack(int capacity) {
        array = new int[capacity];
    }

    @Override
    public void push(int elemnent) {
        if((top + 1) >= array.length) {
            throw new StackFullException();
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
    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(100);
    
        stack.push(1);
        System.out.println("top : " + stack.peek());
        stack.push(2);
        System.out.println("top : " + stack.peek());
        stack.push(3);
        System.out.println("top : " + stack.peek());
        stack.push(4);
        System.out.println("top : " + stack.peek());
        stack.push(5);
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
        System.out.println("top : " + stack.peek());
        stack.pop();
    }
    
}
