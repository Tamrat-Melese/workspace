package com.mpp.library.controller;

import com.mpp.library.dataaccess.LoginDataAccess;
import com.mpp.library.dataaccess.LoginDataAccessImpl;
import com.mpp.library.entity.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private Button login;

	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtPassword;

	@FXML
	private void loginUser(ActionEvent event) {
		StringBuilder builder = new StringBuilder();
		if (txtUsername.getText() != null && txtPassword.getText() != null) {

			builder.append(txtUsername.getText()).append("\n");

			builder.append(txtPassword.getText()).append("\n");

			System.out.println(builder.toString());
		} else {
			// not done
		}
	}

	private static LoginController instance = new LoginController();

	private LoginDataAccess<String, Login> dataAccess = new LoginDataAccessImpl<>();

	public LoginController() {
	}

	public static LoginController getInstance() {
		return instance;
	}

	public Login addUser(Login user) {

		return dataAccess.add(user.getPassword(), user);
	}

	public Login getUser(String password) {
		return dataAccess.get(password);
	}

}
