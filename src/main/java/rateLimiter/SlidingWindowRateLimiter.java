package rateLimiter;

import java.util.*;

public class SlidingWindowRateLimiter implements RateLimiter{
    int maxRequest;
    long maxWindowSize;

    Map<String, Queue<Long>> timestamp;
    public SlidingWindowRateLimiter(int maxRequest, long maxWindowSize) {
        this.maxRequest = maxRequest;
        this.maxWindowSize = maxWindowSize;
        timestamp = new HashMap<>();
    }
    @Override
    public boolean allowRequest(String clientId) {
        long current = System.currentTimeMillis();
        timestamp.putIfAbsent(clientId, new LinkedList<>());
        Queue<Long> timestampValue = timestamp.get(clientId);
        if(!timestampValue.isEmpty() && current-timestampValue.peek()>=maxWindowSize) {
            timestampValue.poll();
        }
        if(timestampValue.size()<maxRequest)  {
            timestampValue.add(current);
            return true;
        }
        return false;
    }
}
