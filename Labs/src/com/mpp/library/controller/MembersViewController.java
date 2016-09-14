package com.mpp.library.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import com.mpp.library.dataaccess.DataAccess;
import com.mpp.library.entity.Person;
import com.mpp.library.util.Constant;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MembersViewController implements Initializable{
	
	@FXML
    private TableView<Person> tblMemberList;

    @FXML
    private TableColumn<Person, Integer> ID;

    @FXML
    private TableColumn<Person, String> firstName;

    @FXML
    private TableColumn<Person, String> lastName;

    @FXML
    private TableColumn<Person, String> phone;

    @FXML
    private TableColumn<Person, String> street;


    @FXML
    private Button btnAddNewMember;
    
    @FXML
    void goMemberAdd(ActionEvent event) throws IOException {
    	try {
	    	Stage stage = (Stage) btnAddNewMember.getScene().getWindow();
	    	Parent root = FXMLLoader.load(getClass().getResource("../" + Constant.MEMBERADD));
	        Scene scene = new Scene(root);
		
	    	stage.setScene(scene);
	    	stage.show();
    	 } catch (IOException e) {
             e.printStackTrace();
         }
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		DataAccess dataAccess  = DataAccessController.getDataAccess();
		
		//start
		HashMap<Integer,Person> hashMap = new HashMap<Integer,Person>();
    	hashMap = (HashMap<Integer, Person>) dataAccess.getAll();

    	ObservableList<Person> personData = FXCollections.observableArrayList();

    	Set set = hashMap.keySet();
        Iterator iter = set.iterator();
    	while(iter.hasNext()){
    		personData.add(hashMap.get(iter.next()));
    	}

    	tblMemberList.setItems(personData);
	}
}
