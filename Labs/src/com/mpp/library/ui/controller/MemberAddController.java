package com.mpp.library.ui.controller;


import com.mpp.library.entity.Address;
import com.mpp.library.entity.Person;
import com.mpp.library.stage.AddNewMemberStage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

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
	
	public void setData(){
		String[] states = {"ALABAMA", "ALASKA", "AMERICAN SAMOA","ARIZONA","ARKANSAS","CALIFORNIA","COLORADO","CONNECTICUT","DELAWARE","DISTRICT OF COLUMBIA","FEDERATED STATES OF MICRONESIA","FLORIDA","GEORGIA","GUAM","HAWAII","IDAHO"};
		cmbState.getItems().clear();
		cmbState.getItems().addAll(states);
		cmbState.setValue(states[0]);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setData();
	}
	
	@FXML
	void goActionCancel(ActionEvent event) throws IOException {
		AddNewMemberStage stage = (AddNewMemberStage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	@FXML
	void addMember(ActionEvent event) throws IOException {
		String vstreet = txtStreet.getText();
		String vcity = txtCity.getText();
		String vstate = cmbState.getSelectionModel().getSelectedItem().toString();

		String vzip = txtZip.getText();
		Address address = new Address(vstreet, vcity, vstate, vzip);
			// TODO: get ID for user. hard code to 11111
		String vmemberId = "11111";
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
	}
}

