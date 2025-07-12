package messageQueue;

public class Consumer implements Runnable{

    private MessageQueue messageQueue;

    public Consumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }
    @Override
    public void run() {
        for(int i =1; i<10; i++) {
            try {
                messageQueue.dequeue();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
