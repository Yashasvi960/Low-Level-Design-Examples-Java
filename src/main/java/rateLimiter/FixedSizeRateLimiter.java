package rateLimiter;

import java.util.*;

public class FixedSizeRateLimiter implements RateLimiter{

    Map<String, Long> windowStartTimes;
    Map<String, Integer> noOfRequest;

    int maxRequest;
    long maxWindowSize;

    public FixedSizeRateLimiter(int maxRequest, long maxWindowSize) {
        this.maxRequest = maxRequest;
        this.maxWindowSize = maxWindowSize;
        windowStartTimes = new HashMap<>();
        noOfRequest = new HashMap<>();
    }
    @Override
    public boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis();
        windowStartTimes.putIfAbsent(clientId, currentTime);
        noOfRequest.putIfAbsent(clientId, 0);
        long currentWidowSize = currentTime-windowStartTimes.get(clientId);
        if(currentWidowSize>=maxWindowSize) {
            windowStartTimes.put(clientId, currentTime);
            noOfRequest.put(clientId, 0);
        }

        if(noOfRequest.get(clientId)< maxRequest) {
            noOfRequest.put(clientId, noOfRequest.get(clientId)+1);
            return true;
        }
        return false;
    }
}
