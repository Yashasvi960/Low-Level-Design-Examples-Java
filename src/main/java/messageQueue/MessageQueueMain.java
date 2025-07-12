package messageQueue;

public class MessageQueueMain {

    public static void main(String args[]) {
        MessageQueue messageQueue = new MessageQueue(5);

        Producer producer = new Producer(messageQueue);
        Consumer consumer = new Consumer(messageQueue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

    }
}
