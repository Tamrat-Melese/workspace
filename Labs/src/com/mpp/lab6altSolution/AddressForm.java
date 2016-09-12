package com.mpp.lab6altSolution;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddressForm extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/AddressForm.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Address Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
