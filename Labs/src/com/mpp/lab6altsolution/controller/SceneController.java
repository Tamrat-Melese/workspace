package com.mpp.lab6altsolution.controller;

import javafx.stage.Stage;

public class SceneController implements SceneResource{
    private static SceneController instance = new SceneController();
    private static Stage primaryStage;


    private SceneController(){}

    public SceneController getInstance(){
        return instance;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        SceneController.primaryStage = primaryStage;
    }
}
