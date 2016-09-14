package com.mpp.library.controller;


import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.mpp.library.dataaccess.DataAccess;
import com.mpp.library.entity.Address;
import com.mpp.library.entity.Person;
import com.mpp.library.util.Constant;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MemberAddController implements Initializable{
	@FXML
	private TextField memberId;

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
	private Button btnCancel;
	
	@FXML
	private Button btnAddMember;
	
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
		goToMemberView();
	}
	
	@FXML
	void addMember(ActionEvent event) throws IOException {
		try {
			String vstreet = txtStreet.getText();
			String vcity = txtCity.getText();
			String vstate = cmbState.getSelectionModel().getSelectedItem().toString();
			
			//End validate
			String vzip = txtZip.getText();
			Address address = new Address(vstreet, vcity, vstate, vzip);

			String vmemberId = DataAccessController.getRandom();
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
			DataAccess dataAccess  = DataAccessController.getDataAccess();
			dataAccess.add(person.getID(), person);
		
			Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Information Dialog");
	    	alert.setHeaderText("Success");
	    	alert.setContentText("Member is added successful !");
	    	alert.showAndWait();
	    	
	    	goToMemberView();
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public void goToMemberView(){
		try{
			Stage stage = (Stage) btnCancel.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("../"+Constant.MEMBERVIEW));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

