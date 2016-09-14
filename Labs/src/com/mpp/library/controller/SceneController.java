package com.mpp.library.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
	
	private static Stage primaryStage;
	private static SceneController controller = null;

	public static void setPrimaryStage(Stage primaryStage) {
		SceneController.primaryStage = primaryStage;
	}
	
	protected SceneController(){}
	
	public static SceneController getInstance() {
		if (controller == null){
			controller = new SceneController();
		}
		return controller;
	}

	public void loadScene(String resource) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource(resource));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
	}
}
