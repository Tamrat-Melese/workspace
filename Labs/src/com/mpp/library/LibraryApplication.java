package com.mpp.library;

import javafx.application.Application;
import javafx.stage.Stage;

public class LibraryApplication extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Library Management System");
    }
}
