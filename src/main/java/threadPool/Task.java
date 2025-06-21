package threadPool;

public class Task implements Runnable{

    String taskValue;

    Task(String taskValue) {
        this.taskValue = taskValue;
    }
    @Override
    public void run() {
        System.out.println("Task executed:" + taskValue);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Task completed:" + taskValue);
    }
}
