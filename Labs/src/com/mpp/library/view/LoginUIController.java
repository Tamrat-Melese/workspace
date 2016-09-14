package mpp.library.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mpp.library.controller.LoginController;
import mpp.library.entity.UserAccount;

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
	private void loginUser(ActionEvent event) throws IOException {
		if (txtUsername.getText() != null && txtPassword.getText() != null) {
			UserAccount userAccount = instance.login(txtUsername.getText(), txtPassword.getText());
			lblErrorMessage.setText("succesfully loggedin");
		}
		else {
			lblErrorMessage.setText("Password or username error");
		}

	}

}
