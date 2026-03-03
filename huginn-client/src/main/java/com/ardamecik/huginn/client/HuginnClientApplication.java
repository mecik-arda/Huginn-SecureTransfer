package com.ardamecik.huginn.client;

import com.ardamecik.huginn.client.ui.TerminalProgressBar;
import java.util.UUID;

public class HuginnClientApplication {

    private static final String DEVELOPER = "Arda Meçik";

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java -jar huginn-client.jar <host> <file>");
            return;
        }

        String host = args[0];
        String filePath = args[1];
        String transferId = UUID.randomUUID().toString();

        System.out.println("Engineered by: " + DEVELOPER);
        System.out.println("Starting transfer to " + host + " for file: " + filePath);
        System.out.println("Transfer ID: " + transferId);

        TerminalProgressBar progressBar = new TerminalProgressBar(100L, 50);
        progressBar.update(100L);
    }
}