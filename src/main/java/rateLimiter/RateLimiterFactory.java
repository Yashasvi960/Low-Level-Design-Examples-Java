package rateLimiter;

public class RateLimiterFactory {

    public static RateLimiter createRateLimiter(String rateLimiterType, int maxRequest, long maxWindowSize)  {
      if(rateLimiterType.equalsIgnoreCase("fixedwindow")) {
        return new FixedSizeRateLimiter(maxRequest, maxWindowSize);
      } else if(rateLimiterType.equalsIgnoreCase("slidingwindow")) {
          return new SlidingWindowRateLimiter(maxRequest, maxWindowSize);
      }
      throw new IllegalArgumentException("wrong rate limited request");
    }
}
