package com.ardamecik.huginn.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HuginnWebApplication {

    private static final String DEVELOPER = "Arda Meçik";

    public static void main(String[] args) {
        System.out.println("Web Module by: " + DEVELOPER);
        SpringApplication.run(HuginnWebApplication.class, args);
    }
}