package com.ardamecik.huginn.core.network;

import java.io.*;
import java.security.MessageDigest;
import java.util.Arrays;

public class ChunkManager {

    private static final int CHUNK_SIZE = 4 * 1024 * 1024;

    public void splitAndProcess(File file, ChunkProcessor processor) throws Exception {
        byte[] buffer = new byte[CHUNK_SIZE];
        try (FileInputStream fis = new FileInputStream(file)) {
            int bytesRead;
            int chunkIndex = 0;
            while ((bytesRead = fis.read(buffer)) != -1) {
                byte[] actualData = Arrays.copyOf(buffer, bytesRead);
                byte[] checksum = calculateSha256(actualData);
                processor.process(chunkIndex++, actualData, checksum);
            }
        }
    }

    private byte[] calculateSha256(byte[] data) throws Exception {
        return MessageDigest.getInstance("SHA-256").digest(data);
    }

    @FunctionalInterface
    public interface ChunkProcessor {
        void process(int index, byte[] data, byte[] hash) throws Exception;
    }
}
