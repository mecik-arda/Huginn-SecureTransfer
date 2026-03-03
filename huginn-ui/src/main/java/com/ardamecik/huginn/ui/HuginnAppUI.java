package com.ardamecik.huginn.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HuginnAppUI extends Application {

    private static final String DEVELOPER = "Arda Meçik";

    @Override
    public void start(Stage primaryStage) {
        System.out.println("UI Engine by: " + DEVELOPER);
        Label label = new Label("Huginn Secure Transfer Dashboard");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("Huginn SFT-Pro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}