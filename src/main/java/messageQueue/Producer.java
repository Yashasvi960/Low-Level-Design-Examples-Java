package messageQueue;

public class Producer implements Runnable{

    private MessageQueue messageQueue;

    public Producer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }
    @Override
    public void run() {
      for(int i = 1; i<=10; i++) {
          try {
              messageQueue.enqueue("Message " + i);
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      }
    }
}
