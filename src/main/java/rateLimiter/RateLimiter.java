package rateLimiter;

public interface RateLimiter {
    
    public boolean allowRequest(String clientId);
}
