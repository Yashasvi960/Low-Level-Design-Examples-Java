package rateLimiter;

public class RateLimiterMain {

    public static void main(String args[]) {
        RateLimiter rateLimiter1 = RateLimiterFactory.createRateLimiter("fixedwindow", 10, 60000);
        RateLimiter rateLimiter2 = RateLimiterFactory.createRateLimiter("slidingwindow", 10,6000);

        System.out.println("fixed window call");

        for(int i = 0; i<12; i++) {
            System.out.println(rateLimiter1.allowRequest("client1"));
        }

        System.out.println("sliding window call");

        for(int i = 0; i<12; i++) {
            System.out.println(rateLimiter2.allowRequest("client2"));
        }

    }
}
