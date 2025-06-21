package threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool {
    private static ThreadPool instance;
    private final BlockingQueue<Runnable> taskQueue;
    private final AtomicBoolean isShutDownInitiated;

    private final Thread[] workers;

    private ThreadPool(int numOfInstances) {
        taskQueue = new LinkedBlockingQueue<>();
        isShutDownInitiated = new AtomicBoolean(false);
        workers = new Thread[numOfInstances];

        for(int i = 0; i<numOfInstances; i++) {
            workers[i] = new Worker(taskQueue, isShutDownInitiated);
            workers[i].start();
        }
    }

    public static synchronized ThreadPool getInstance(int numOfInstances) {
        if(instance==null) {
            return new ThreadPool(numOfInstances);
        }
        return instance;
    }

    public void submitTask(Task task) {
        if(!isShutDownInitiated.get()) {
            taskQueue.offer(task);
        }

    }

    public void shutDown() {
        isShutDownInitiated.set(true);
        for(Thread worker: workers) {
            worker.interrupt();
        }
    }

}
