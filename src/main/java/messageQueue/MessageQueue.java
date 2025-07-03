package messageQueue;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {

    private Queue<String> queue;
    private int capacity = 0;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public synchronized void enqueue(String message) throws InterruptedException {
        while(queue.size()==capacity) {
            wait();
        }
        queue.add(message);
        System.out.println("Message added to queue: " + message);
        notifyAll();
    }

    public synchronized String dequeue() throws InterruptedException {
        if(queue.isEmpty())  {
            wait();
        }
        String message = queue.poll();
        System.out.println("Message processed: " + message);
        notifyAll();
        return message;
    }

}
