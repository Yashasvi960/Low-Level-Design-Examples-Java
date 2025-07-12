package amongus;


public class Player implements Runnable{
    private int id;
    private final GameState game;

    public Player(int id, GameState game) {
        this.id = id;
        this.game = game;
    }
    @Override
    public void run() {
        try {
            Thread.sleep((int)Math.random()*1000);
             game.movePlayer(id, new Position(0,0));
             game.completeTask(id);
             game.reportBody(id);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
