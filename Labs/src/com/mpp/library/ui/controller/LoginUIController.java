package com.mpp.library.ui.controller;

import com.mpp.library.controller.LoginController;
import com.mpp.library.entity.LoggedUser;
import com.mpp.library.entity.UserAccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginUIController {

	public LoginUIController() {
	}
	
	private static LoginController instance = LoginController.getInstance();

	@FXML
	private Button login;

	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtPassword;

	@FXML
	private Label lblErrorMessage;

	@FXML
	private void loginUser(ActionEvent event) throws Exception {
		UserAccount userAccount = null;
		if (txtUsername.getText() != null && txtPassword.getText() != null) {
			userAccount = instance.login(txtUsername.getText(), txtPassword.getText());
			if (userAccount != null) {
				LoggedUser.getInstance().setPerson(userAccount.getPerson());
				
				Parent root = SceneController.getInstance().loadLayout(SceneResource.MAIN_VIEW_FXML);
				Scene scene = new Scene(root);

				Stage mainStage = new Stage();
				mainStage.setTitle(SceneResource.APP_NAME);
				mainStage.setScene(scene);
				mainStage.show();

				Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
				primaryStage.close();
			}
		}
		
		if (userAccount == null) {
			lblErrorMessage.setText("Password or username error");
		}

	}

}