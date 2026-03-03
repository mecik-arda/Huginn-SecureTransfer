package com.ardamecik.huginn.client.ui;

public class TerminalProgressBar {

    private final long totalBytes;
    private final int barLength;
    private final long startTime;

    public TerminalProgressBar(long totalBytes, int barLength) {
        this.totalBytes = totalBytes;
        this.barLength = barLength;
        this.startTime = System.currentTimeMillis();
    }

    public void update(long currentBytes) {
        int progress = (int) ((currentBytes * barLength) / totalBytes);
        int percentage = (int) ((currentBytes * 100) / totalBytes);
        
        long elapsedTime = System.currentTimeMillis() - startTime;
        double speed = (currentBytes / 1024.0 / 1024.0) / (elapsedTime > 0 ? elapsedTime / 1000.0 : 1.0);

        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            if (i < progress) {
                bar.append("=");
            } else if (i == progress) {
                bar.append(">");
            } else {
                bar.append(" ");
            }
        }
        bar.append("]");

        System.out.print(String.format("\r\033[36mHUGINN >\033[0m %s %d%% | %.2f MB/s", bar.toString(), percentage, speed));

        if (currentBytes >= totalBytes) {
            System.out.println();
        }
    }
}
