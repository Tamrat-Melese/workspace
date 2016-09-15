package com.mpp.library.ui.controller;

import com.mpp.library.entity.Person;
import com.mpp.library.stage.AddNewMemberStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MembersViewController implements Initializable{
	
	@FXML
    private TableView<Person> tblMemberList;

    @FXML
    private Button btnAddNewMember;
    
    @FXML
    void goMemberAdd(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnAddNewMember.getScene().getWindow();
		AddNewMemberStage addNewMemberStage = new AddNewMemberStage(stage, tblMemberList);
		addNewMemberStage.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO: get person in database
	}
}
