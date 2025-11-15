package RateLimiter;
import java.util.concurrent.TimeUnit;

/**
 * Implements the Token Bucket algorithm for rate limiting in a thread-safe manner.
 */
public class RateLimiter {

    // --- Configuration Constants ---
    private static final int DEFAULT_CAPACITY = 10;   // Max tokens the bucket can hold (allows for bursts)
    private static final int DEFAULT_REFILL_RATE = 2; // Tokens added per second (the sustained rate)

    public static class TokenBucketRateLimiter {
        private final int capacity;
        private final int refillRate; // Tokens per second
        private double tokens;
        private long lastRefillTime; // In milliseconds

        /**
         * Initializes the rate limiter instance.
         *
         * @param capacity The maximum number of tokens the bucket can hold.
         * @param refillRate The rate at which tokens are added (tokens per second).
         */
        public TokenBucketRateLimiter(int capacity, int refillRate) {
            this.capacity = capacity;
            this.refillRate = refillRate;
            this.tokens = capacity; // Start with a full bucket
            this.lastRefillTime = System.currentTimeMillis();
        }

        /**
         * Refills the bucket by calculating the tokens earned since the last call (lazy refill).
         * This method is called before checking for token availability.
         */
        private void refill() {
            long currentTime = System.currentTimeMillis();
            
            // Calculate time elapsed in seconds (milliseconds / 1000.0)
            double timeElapsedSeconds = (currentTime - lastRefillTime) / 1000.0;
            
            // Calculate tokens to add (tokens/sec * seconds)
            double tokensToAdd = timeElapsedSeconds * refillRate;
            
            // Add tokens, ensuring we don't exceed the capacity
            this.tokens = Math.min(this.capacity, this.tokens + tokensToAdd);
            
            // Update the last refill time
            this.lastRefillTime = currentTime;
        }

        /**
         * Checks if a request is allowed by consuming a token if available.
         * This method is synchronized to ensure thread safety when reading/updating state.
         *
         * @return True if the request is allowed, False otherwise.
         */
        public synchronized boolean allowRequest() {
            // 1. First, refill the bucket
            refill();

            // 2. Check if a token is available
            if (this.tokens >= 1) {
                // 3. Consume one token and allow the request
                this.tokens -= 1;
                System.out.printf("Request ALLOWED. Current tokens left: %.2f\n", this.tokens);
                return true;
            } else {
                // 4. Request blocked
                System.out.printf("Request BLOCKED. Current tokens left: %.2f (Rate Limit Exceeded)\n", this.tokens);
                return false;
            }
        }
    }

    /**
     * Simulates sending multiple requests to the rate limiter.
     */
    private static void demonstrateRateLimiter(TokenBucketRateLimiter limiter, int numRequests, long intervalMillis) throws InterruptedException {
        System.out.println("--------------------------------------------------");
        System.out.printf("Starting simulation with Capacity=%d, Rate=%d tokens/sec\n", limiter.capacity, limiter.refillRate);
        System.out.println("--------------------------------------------------");

        int allowedCount = 0;

        for (int i = 1; i <= numRequests; i++) {
            // Simulate a time delay between requests
            if (i > 1 && intervalMillis > 0) {
                Thread.sleep(intervalMillis);
            }

            // Check if the request is allowed
            if (limiter.allowRequest()) {
                allowedCount++;
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Simulation finished: %d requests allowed out of %d.\n", allowedCount, numRequests);
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) throws InterruptedException {
        // Initialize the limiter: 10 burst capacity, 2 requests/second sustained rate
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(DEFAULT_CAPACITY, DEFAULT_REFILL_RATE);

        // Scenario 1: Burst of requests (15 requests sent immediately)
        // The first 10 should be allowed (Capacity), and the rest blocked until tokens refill.
        System.out.println("\n--- SCENARIO 1: Immediate Burst of 15 Requests (interval=10ms) ---");
        demonstrateRateLimiter(limiter, 15, 10);

        // Reset limiter for the next scenario
        limiter = new TokenBucketRateLimiter(DEFAULT_CAPACITY, DEFAULT_REFILL_RATE);

        // Scenario 2: Steady rate of requests (5 requests sent at 500 millisecond intervals)
        // The refill rate is 2 tokens/sec, meaning 1 token refills every 0.5 sec.
        // This should perfectly match the consumption rate.
        System.out.println("\n--- SCENARIO 2: Steady Requests (5 requests at 500ms intervals) ---");
        demonstrateRateLimiter(limiter, 5, 100);

        // Scenario 3: Wait a while and burst again (demonstrating the token recharge)
        System.out.println("\n--- SCENARIO 3: Wait 3 seconds, then send a burst of 5 ---");
        TimeUnit.SECONDS.sleep(3); // Wait 3 seconds (should refill 3*2 = 6 tokens, bucket will be full at 10)
        demonstrateRateLimiter(limiter, 5, 10);
    }
}