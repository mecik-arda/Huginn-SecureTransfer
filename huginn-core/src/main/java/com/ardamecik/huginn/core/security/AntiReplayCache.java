package com.ardamecik.huginn.core.security;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.time.Instant;

public class AntiReplayCache {

    private final Map<UUID, Long> cache = new ConcurrentHashMap<>();
    private final long ttlSeconds;

    public AntiReplayCache(long ttlSeconds) {
        this.ttlSeconds = ttlSeconds;
    }

    public boolean validate(UUID nonce, long timestamp) {
        long now = Instant.now().getEpochSecond();
        if (Math.abs(now - timestamp) > ttlSeconds) return false;
        if (cache.containsKey(nonce)) return false;
        
        cache.put(nonce, timestamp);
        cleanExpired(now);
        return true;
    }

    private void cleanExpired(long now) {
        cache.entrySet().removeIf(entry -> (now - entry.getValue()) > ttlSeconds);
    }
}
