import java.util.NoSuchElementException;

public class LinkedStack implements Stack{
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this(data, null);
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    Node top;
    int size;

    public LinkedStack() {
        this.top = null;
    }

    public LinkedStack(Node top){
        this.top = top;
    }

    @Override
    public void push(int elemnent) {
        if(top == null) {
            top = new Node(elemnent);
        }
        top = new Node(elemnent, top);
        size++;
    }

    @Override
    public int pop() {
        if(top == null) {
            throw new NoSuchElementException();
        }
        int data = top.data;
        top = top.next;
        size--;
        return data;
    }

    @Override
    public int peek() {
        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
    
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
