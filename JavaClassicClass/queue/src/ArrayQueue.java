import java.util.Arrays;
import java.util.NoSuchElementException;

// 주석은 선생님 코드
public class ArrayQueue implements Queue{
    static final int DEFAULT_CAPACITY = 10;
    int front, rear;
    int[] elements;
    int capacity;

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
        }
    
    public ArrayQueue(int capacity) {
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

    public static void main1(String[] args) {
        ArrayQueue q = new ArrayQueue();
        System.out.println("queue: " + q);
        q.enqueue(1);
        System.out.println("enquque 1 : " + q.toString());
        q.enqueue(2);
        System.out.println("enquque 2 : " + q.toString());
        q.enqueue(3);
        System.out.println("enquque 3 : " + q.toString());
        q.enqueue(4);
        System.out.println("enquque 4 : " + q.toString());
        q.enqueue(5);
        System.out.println("enquque 5 : " + q.toString());
        int data1 = q.dequeue();
        System.out.println("dequque " + q.toString() + " : " + data1);
        int data2 = q.dequeue();
        System.out.println("dequque " + q.toString() + " : " + data2);
        int data3 = q.dequeue();
        System.out.println("dequque " + q.toString() + " : " + data3);
        int data4 = q.dequeue();
        System.out.println("dequque " + q.toString() + " : " + data4);
        int data5 = q.dequeue();
        System.out.println("dequque " + q.toString() + " : " + data5);
        
        for (int i = 1; i <= 5; i++) {
            q.enqueue(i);
            System.out.println("enquque: " + i + " : " + q);
        }

        for (int i = 1; i <= 5; i++) {
            int data = q.dequeue();
            System.out.println("dequeue " + q + " : " + data);
        }
    }
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(2);

        System.out.printf("%15s | %7s | %4s | %s%n",
                "Command", "isEmpty", "Size", "Elements");
        queue.enqueue(1);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.queue(1)",
        queue.isEmpty(), queue.size(), queue.toString());
        queue.enqueue(2);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.queue(2)",
        queue.isEmpty(), queue.size(), queue.toString());
        queue.enqueue(3);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.queue(3)",
        queue.isEmpty(), queue.size(), queue.toString());
        queue.enqueue(4);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.queue(4)",
        queue.isEmpty(), queue.size(), queue.toString());
        queue.enqueue(5);
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.queue(5)",
        queue.isEmpty(), queue.size(), queue.toString());
        queue.dequeue();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.dequeue()",
        queue.isEmpty(), queue.size(), queue.toString());
        queue.dequeue();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.dequeue()",
        queue.isEmpty(), queue.size(), queue.toString());
        queue.dequeue();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.dequeue()",
        queue.isEmpty(), queue.size(), queue.toString());
        queue.dequeue();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.dequeue()",
        queue.isEmpty(), queue.size(), queue.toString());
        queue.dequeue();
        System.out.printf("%15s | %7s | %4d | %s%n", "queue.dequeue()",
        queue.isEmpty(), queue.size(), queue.toString());
    }

    
}
