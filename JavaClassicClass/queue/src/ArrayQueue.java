import java.util.NoSuchElementException;

// 주석은 선생님 코드
public class ArrayQueue implements Queue{
    static final int DEFAULT_CAPACITY = 10;
    int front, rear;
    int[] elements;

    public ArrayQueue(){
        elements = new int[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(int element) {
        if(rear == elements.length) {
            rear = 0;
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
        elements[front] = 0;
        if(front == elements.length) {
            front = 0;
        } else {
            front++;
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

    public static void main(String[] args) {
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
    
}
