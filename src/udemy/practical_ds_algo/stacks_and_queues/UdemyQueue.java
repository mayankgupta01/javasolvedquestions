package udemy.practical_ds_algo.stacks_and_queues;

/**
 * Created by mayank.gupta on 12/02/17.
 */
public class UdemyQueue {

    private int front;
    private int back;
    private int queueSize;
    private int maxSize;
    private long[] queueArray;

    public UdemyQueue(int size) {
        this.maxSize = size;
        this.front = 0;
        this.back = -1;
        this.queueSize = 0;
        this.queueArray = new long[maxSize];
    }

    public void enQueue(long j) {
        if(isFull()) {
            System.out.println("Queue is already full !");
        }else {
            back++;
            queueSize++;
            queueArray[back] = j;
        }
    }

    public long deQueue() {
       if(isEmpty()) {
           System.out.println("Queue is already empty !");
           return -1;
       }else {
           int old_index = front;
           front++;
           if(front == maxSize) {
               front = 0; // so we can utilize the queue from starting again.
           }
           queueSize--;
           return queueArray[old_index];
       }
    }

    public long peek() {
        if(isEmpty()) {
            System.out.println("Queue is already empty !");
            return -1;
        }
        else
            return queueArray[front];
    }

    public int sizeOfQueue() {
        return queueSize;
    }

    public boolean isEmpty() {
        return (queueSize == 0);
    }

    public boolean isFull() {
        return (queueSize == maxSize);
    }
}
