import java.util.Arrays;
import java.util.NoSuchElementException;

// 주석은 선생님 코드
public class CircularArrayQueue implements Queue{
    static final int DEFAULT_CAPACITY = 10;
    int front, rear;
    int[] elements;
    int capacity;

    public CircularArrayQueue(){
        this(DEFAULT_CAPACITY);
        }
    
    public CircularArrayQueue(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        elements = new int[capacity];
    }

    @Override
    public void enqueue(int element) {
        if(rear >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length + capacity);
        }
        elements[rear++] = element;

        /*
        if(rear >= elements.length) {
            throw new QueueFullException();
        }
        elements[rear++] = element;
        */
    }

    @Override
    public int dequeue() {
        int data = elements[front];
        elements[front++] = 0;
        if(front >= capacity) {
            elements = Arrays.copyOfRange(elements, capacity, capacity+rear-front);
            front -= capacity;
            rear -= capacity;
        }
        return data;
        /*
        if(front < rear) {
            throw new NoSuchElementException();
        }
        return elements[front++];
        */
    }

    @Override
    public int peek() {
        return elements[front];
        /*
        if(front < rear) {
            throw new NoSuchElementException();
        }
        return elements[front];
        */
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
        /*
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(front < rear) {
            sb.append(elements[front]);
        }

        for(int index = front + 1; index < rear; index++) {
            sb.append(", ").append(elements[index]);
        }
        sb.append("]");
        return sb.toString();
        */
    }

    public int size(){
        return rear - front;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public int getCapacity(){
        return elements.length;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(2);
        CircularArrayQueue circularQueue = new CircularArrayQueue(2);

        System.out.printf("%10s | %10s | %10s | %10s | %10s | %10s%n",
                "queue", "Capacity", "Elements", "circularQueue", "Capacity", "Elements");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%10s | %10d | %10s | %10s | %10d | %10s%n",
                    "queue", queue.getCapacity(), queue.toString(),
                    "circularQueue", circularQueue.getCapacity(), circularQueue.toString());
            queue.enqueue(i);
            circularQueue.enqueue(i);
            System.out.printf("%10s | %10d | %10s | %10s | %10d | %10s%n",
                    "queue", queue.getCapacity(), queue.toString(),
                    "circularQueue", circularQueue.getCapacity(), circularQueue.toString());
            queue.dequeue();
            circularQueue.dequeue();
        }
        System.out.printf("%10s | %10d | %10s | %10s | %10d | %10s%n",
                "queue", queue.getCapacity(), queue.toString(),
                "circularQueue", circularQueue.getCapacity(), circularQueue.toString());
    }

    
}
