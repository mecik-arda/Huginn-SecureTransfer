package com.ardamecik.huginn.server.security;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterBucket {

    private final int maxTokens;
    private final long refillIntervalMillis;
    private final Map<String, TokenBucket> clientBuckets;

    public RateLimiterBucket(int maxTokens) {
        this.maxTokens = maxTokens;
        this.refillIntervalMillis = 60000 / maxTokens; 
        this.clientBuckets = new ConcurrentHashMap<>();
    }

    public boolean tryConsume(String ipAddress) {
        clientBuckets.putIfAbsent(ipAddress, new TokenBucket(maxTokens));
        return clientBuckets.get(ipAddress).consume();
    }

    private class TokenBucket {
        private int tokens;
        private long lastRefillTimestamp;

        public TokenBucket(int maxTokens) {
            this.tokens = maxTokens;
            this.lastRefillTimestamp = Instant.now().toEpochMilli();
        }

        public synchronized boolean consume() {
            refill();
            if (tokens > 0) {
                tokens--;
                return true;
            }
            return false;
        }

        private void refill() {
            long now = Instant.now().toEpochMilli();
            long tokensToAdd = (now - lastRefillTimestamp) / refillIntervalMillis;
            if (tokensToAdd > 0) {
                tokens = Math.min(tokens + (int) tokensToAdd, maxTokens);
                lastRefillTimestamp = now;
            }
        }
    }
}
