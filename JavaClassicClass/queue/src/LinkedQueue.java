import java.util.Arrays;
import java.util.NoSuchElementException;

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
    Node front, rear;
    int capacity;
    int[] elements;
    int count;
    
    public LinkedQueue(){
        this(DEFAULT_CAPACITY);
    }

    public LinkedQueue(int capacity){
        this.capacity = capacity;
        elements = new int[capacity];
    }

    @Override
    public void enqueue(int element) {
        if(count ==0) {
            front = rear= new Node(element);
            count++;
        } else {
            rear.next = new Node(element);
            rear = rear.next;
            count++;
        }
    }

    @Override
    public int dequeue() {

        if(count == 0) {
            throw new NoSuchElementException();
        }

        int data = front.data;
        front = front.next;
        --count;
        if(front == null) {
            rear = null;
        }

        return data;
    }

    @Override
    public int peek() {
        if(count ==0) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public String toString(){
        // String result = "[";
        // if(front != rear) {
        //     result += elements[front];
        // }
        // for(int i = front+1; i < rear; i++){
        //     result += (","+elements[i]);
        // }
        
        // return result += "]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node p = front;
        if(p != null) {
            sb.append(p.data);
            p = p.next;
        }
        while(p!= null) {
            sb.append(", ").append(p.data);
            p = p.next;
        }
        
        sb.append("]");
        return sb.toString();
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
