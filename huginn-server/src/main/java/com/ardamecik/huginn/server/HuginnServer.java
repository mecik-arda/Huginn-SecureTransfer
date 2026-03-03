package com.ardamecik.huginn.server;

import com.ardamecik.huginn.server.security.RateLimiterBucket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HuginnServer {

    private static final Logger log = LoggerFactory.getLogger(HuginnServer.class);
    private final int port;
    private final ExecutorService threadPool;
    private final RateLimiterBucket rateLimiter;
    private volatile boolean isRunning;

    public HuginnServer(int port, int maxThreads, RateLimiterBucket rateLimiter) {
        this.port = port;
        this.threadPool = Executors.newFixedThreadPool(maxThreads);
        this.rateLimiter = rateLimiter;
        this.isRunning = true;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("Huginn Server started on port " + port + " by Arda Meçik");

            while (isRunning) {
                Socket clientSocket = serverSocket.accept();
                String clientIp = clientSocket.getInetAddress().getHostAddress();

                if (!rateLimiter.tryConsume(clientIp)) {
                    log.warn("Rate limit exceeded for IP: " + clientIp);
                    clientSocket.close();
                    continue;
                }

                threadPool.execute(new ClientHandler(clientSocket));
            }
        } catch (Exception e) {
            log.error("Server error: ", e);
        }
    }

    public void stop() {
        isRunning = false;
        threadPool.shutdown();
    }

    private class ClientHandler implements Runnable {
        private final Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {
                log.info("New connection handled: " + socket.getInetAddress());
                
            } catch (IOException e) {
                log.error("Handler error: ", e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    log.error("Socket close error: ", e);
                }
            }
        }
    }
}
