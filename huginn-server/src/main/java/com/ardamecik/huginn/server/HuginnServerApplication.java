package com.ardamecik.huginn.server;

import com.ardamecik.huginn.server.security.RateLimiterBucket;

public class HuginnServerApplication {

    private static final String DEVELOPER = "Arda Meçik";

    public static void main(String[] args) {
        System.out.println("Huginn Server by: " + DEVELOPER);
        
        RateLimiterBucket rateLimiter = new RateLimiterBucket(100);
        HuginnServer server = new HuginnServer(8081, 10, rateLimiter);
        server.start();
    }
}