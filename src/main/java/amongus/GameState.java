package amongus;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class GameState {

    private final Map<Integer, Position> playerPositions = new ConcurrentHashMap<>();
    private final Set<Integer> alivePlayer = ConcurrentHashMap.newKeySet();
    private final Map<Integer, Boolean> taskCompleted = new ConcurrentHashMap<>();
    private final ReentrantLock reportLock = new ReentrantLock();
    private final ReentrantLock meetingLock = new ReentrantLock();
    private final ReentrantLock taskLock = new ReentrantLock();
    private final ReentrantLock voteLock = new ReentrantLock();
    private volatile boolean meetingInProgress = false;
    private final AtomicInteger bodyReported = new AtomicInteger();

    public void movePlayer(int playerId, Position playerPosition ) {
        playerPositions.put(playerId, playerPosition);
    }

    public void completeTask(int playerId) {
        taskLock.lock();
        try{
            taskCompleted.put(playerId, true);
            System.out.println("Player " + playerId + " completed a task.");
        } finally{
            taskLock.unlock();
        }

    }


    public void reportBody(int playerId) {
        if(reportLock.tryLock()) {
            try{
                if(meetingInProgress) return;
                meetingInProgress = true;
                bodyReported.incrementAndGet();
                callMeeting(playerId);
            } finally {
                reportLock.unlock();
            }

        }else {
            System.out.println("Tried to report body but someone else reported");
        }
    }

    private void callMeeting(int playerId) {
        meetingLock.lock();
        try{
            System.out.println("Emergency meeting started by Player " + playerId);
            conductVoting();
            meetingInProgress = false;
        } finally {
            meetingLock.unlock();
        }

    }

    private void conductVoting() {
        voteLock.lock();
        try{
            System.out.println("Voting is happenning...");
        } finally {
            voteLock.unlock();
        }
    }
}
