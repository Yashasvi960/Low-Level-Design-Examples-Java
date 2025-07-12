package amongus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AmongUsMain {

    public static void main(String args[]) throws InterruptedException {
        GameState state = new GameState();
        ExecutorService executor = Executors.newFixedThreadPool(15);

        for(int i = 0; i<15; i++) {
            executor.submit(new Player(i, state));
        }

        executor.shutdown();;
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
