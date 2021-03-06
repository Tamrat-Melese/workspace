package com.mpp.library.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.mpp.library.controller.LoginController;
import com.mpp.library.entity.LoggedUser;
import com.mpp.library.entity.UserAccount;

import com.mpp.library.stage.MainStage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginUIController implements Initializable{

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

				MainStage mainStage = new MainStage();
				mainStage.show();

				Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
				primaryStage.close();
			}
		}
		
		if (userAccount == null) {
			setMessage(lblErrorMessage, "Password and Username does not match", Color.RED);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String[] messErrorUserName = {"Username cannot blank.", "Username length is at least 3"};
		String[] messErrorPassword = {"Password cannot blank.", "Password length is at least 3"};
		checkValidTextField(txtUsername, lblErrorMessage, messErrorUserName);
		checkValidTextField(txtPassword, lblErrorMessage, messErrorPassword);
	}
	
	// Start validation
	public boolean isEmpty(String txt) {
		if (txt.isEmpty())
			return false;
		return true;
	}
	
	public boolean isValidLength(String txt) {
		if (txt.length() < 3)
			return false;
		return true;
	}
	
	public void checkValidTextField(TextField txtField, Label lblField, String[] mess) {
		txtField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (txtField.isFocused() == false) {
				if (!isEmpty(txtField.getText().trim())) {
					lblField.setVisible(true);
					setMessage(lblField, mess[0], Color.RED);
				}  else if (!isValidLength(txtField.getText().trim())) {
					lblField.setVisible(true);
					setMessage(lblField, mess[1], Color.RED);
				}else {
					lblField.setVisible(false);
					lblField.setText("");
				}
			}
		});
		txtField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(txtUsername.getText().trim().length()<3 || txtPassword.getText().trim().length() < 3){
					login.setDisable(true);
				} else {
					login.setDisable(false);
				}
			}
		});
	}

	public void setMessage(Label l, String message, Color color) {
		l.setText(message);
		l.setTextFill(color);
		l.setVisible(true);
	}

	public void showDialog(String title, String headerText, String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
}
