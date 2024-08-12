import java.util.Arrays;

public class LinkedQueue implements Queue{
    class Node{
        int data;
        Node next;

        public Node(int data) {
            this(data, null);
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static final int DEFAULT_CAPACITY = 10;
    int front, rear;
    int capacity;
    int[] elements;
    
    public LinkedQueue(){
        this(DEFAULT_CAPACITY);
    }

    public LinkedQueue(int capacity){
        this.capacity = capacity;
        elements = new int[capacity];
    }

    @Override
    public void enqueue(int element) {
        if(rear >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length + capacity);
        }
        elements[rear++] = element;
    }

    @Override
    public int dequeue() {
        int data = elements[front];
        elements[front++] = 0;
        if(front >= capacity) {
            elements = Arrays.copyOfRange(elements, capacity, rear-front);
            front -= capacity;
            rear -= capacity;
        }
        return data;
    }

    @Override
    public int peek() {
        return elements[front];
    }

    public int size(){
        return rear- front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public String toString(){
        String result = "[";
        if(front != rear) {
            result += elements[front];
        }
        for(int i = front+1; i < rear; i++){
            result += (","+elements[i]);
        }
        
        return result += "]";
    }

    public static void main(String[] args) {
        Queue queue = new LinkedQueue();

        System.out.println("queue : " + queue);
        queue.enqueue(1);
        System.out.println("queue : " + queue);
        queue.enqueue(2);
        System.out.println("queue : " + queue);
        queue.enqueue(3);
        System.out.println("queue : " + queue);
        queue.enqueue(4);
        System.out.println("queue : " + queue);
        queue.enqueue(5);
        System.out.println("queue : " + queue);
        queue.dequeue();
        System.out.println("queue : " + queue);
        queue.dequeue();
        System.out.println("queue : " + queue);
        queue.dequeue();
        System.out.println("queue : " + queue);
        queue.dequeue();
        System.out.println("queue : " + queue);
        queue.dequeue();
        System.out.println("queue : " + queue);
    }

}
