package com.ardamecik.huginn.core.model;

public record TransferRecord(
    String fileName, 
    String fileType, 
    String status, 
    String timestamp, 
    int timeLeftMinutes
) {}