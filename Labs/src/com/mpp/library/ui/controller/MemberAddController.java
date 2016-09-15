package com.mpp.library.ui.controller;


import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import com.mpp.library.controller.UserController;
import com.mpp.library.entity.Address;
import com.mpp.library.entity.Person;
import com.mpp.library.stage.AddNewMemberStage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class MemberAddController implements Initializable{
	@FXML
	private TextField txtFirstName;

	@FXML
	private TextField txtLastName;

	@FXML
	private TextField txtPhone;

	@FXML
	private TextField txtStreet;
	
	@FXML
	private TextField txtCity;
	
	@FXML
	private TextField txtZip;
	
	@FXML
	private ComboBox cmbState;
	
	@FXML
	private CheckBox cbAdmin;
	@FXML
	private CheckBox cbLibrarian;
	@FXML
	private CheckBox cbMember;
	
	@FXML
	private Label lblFirstNameError;

	@FXML
	private Label lblLastNameError;

	@FXML
	private Label lblStreetError;

	@FXML
	private Label lblCityError;

	@FXML
	private Label lblZipError;

	@FXML
	private Label lblPhoneError;	
	
	private UserController userController = UserController.getInstance();
	
	public void setData(){
		String[] states = {"California", "Alabama", "Arkansas", "Arizona", "Alaska", "Colorado",
				"Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
				"Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
				"Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
				"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota",
				"Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
				"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin",
				"Wyoming"};
		cmbState.getItems().clear();
		cmbState.getItems().addAll(states);
		cmbState.setValue(states[0]);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setData();
		
		checkValidTextField(txtFirstName, lblFirstNameError);
		checkValidTextField(txtLastName, lblLastNameError);
		checkValidTextField(txtCity, lblCityError);
		checkValidTextField(txtPhone, lblPhoneError);
		checkValidTextField(txtStreet, lblStreetError);
		checkValidTextField(txtZip, lblZipError);
	}
	
	@FXML
	void goActionCancel(ActionEvent event) throws IOException {
		AddNewMemberStage stage = (AddNewMemberStage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	@FXML
	void addMember(ActionEvent event) throws IOException {
		if (!isEmpty(lblFirstNameError.getText()) && !isEmpty(lblCityError.getText())
				&& !isEmpty(lblLastNameError.getText()) && !isEmpty(lblPhoneError.getText())
				&& !isEmpty(lblStreetError.getText()) && !isEmpty(lblZipError.getText())) {
		String vstreet = txtStreet.getText();
		String vcity = txtCity.getText();
		String vstate = cmbState.getSelectionModel().getSelectedItem().toString();

		String vzip = txtZip.getText();
		Address address = new Address(vstreet, vcity, vstate, vzip);
		String vmemberId = userController.getUniqueID();
		String vfirstName = txtFirstName.getText();
		String vlastName = txtLastName.getText();
		String vphoneNumber = txtPhone.getText();

		Person person = new Person(vmemberId, vfirstName, vlastName, address, vphoneNumber);
		//Start Role
		Set roles = new HashSet<>();
		if(cbAdmin.isSelected())
			roles.add(cbAdmin.getText());
		if(cbLibrarian.isSelected())
			roles.add(cbLibrarian.getText());
		if(cbMember.isSelected())
			roles.add(cbMember.getText());
		person.setRoles(roles);
			//End Role

		AddNewMemberStage stage = (AddNewMemberStage)((Node)event.getSource()).getScene().getWindow();
		stage.addMember(person);
		stage.close();
		} else {
			showDialog("Error Input", "Error", "Please input correct all value!");
		}
	}

	// Start validation
	public boolean isEmpty(String txt) {
		if (txt.isEmpty())
			return false;
		return true;
	}

	public boolean isNumber(String text) {
		return text.trim().matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}

	public void checkValidTextField(TextField txtField, Label lblField) {

		txtField.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (txtField.isFocused() == false) {
				if (!isEmpty(txtField.getText().trim())) {
					lblField.setVisible(true);
					setMessage(lblField, "You can't leave this empty.", Color.RED);
				} else if ((txtField.getId().equals(txtZip.getId()) || txtField.getId().equals(txtPhone.getId()))
						&& !isNumber(txtField.getText().trim())) {
					setMessage(lblField, "Please input number", Color.RED);
				} else {
					lblField.setVisible(false);
					lblField.setText("");
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
