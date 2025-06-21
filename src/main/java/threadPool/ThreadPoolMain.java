package threadPool;

public class ThreadPoolMain {

    public static void main(String args[]) {
        ThreadPool pool = ThreadPool.getInstance(3);
        for(int i = 0; i<10; i++) {
            Task task = new Task("Task - "+ i);
            pool.submitTask(task);
        }
        pool.shutDown();
    }
}
