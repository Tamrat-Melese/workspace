package com.mpp.library.ui.controller;

import com.mpp.library.controller.UserController;
import com.mpp.library.entity.Person;
import com.mpp.library.stage.AddNewMemberStage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class MembersViewController {
	
	@FXML
    private TableView<Person> tblMemberList;

    @FXML
    private Button btnAddNewMember;

	@FXML
	private TableColumn address;
    
    private UserController userController = UserController.getInstance();
    private ObservableList<Person> values = FXCollections.observableArrayList();

	@FXML
	private void initialize() {
		address.prefWidthProperty().bind(tblMemberList.widthProperty().subtract(440));
		values.addAll(userController.getAll());
		tblMemberList.setItems(values);
	}
    
    @FXML
    void goMemberAdd(ActionEvent event) throws Exception {
		Stage stage = (Stage) btnAddNewMember.getScene().getWindow();
		AddNewMemberStage addNewMemberStage = new AddNewMemberStage(stage, tblMemberList);
		addNewMemberStage.show();
    }
}
