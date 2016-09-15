package com.mpp.library.stage;

import com.mpp.library.entity.Person;
import com.mpp.library.ui.controller.SceneController;
import com.mpp.library.ui.controller.SceneResource;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddNewMemberStage extends Stage{
    private TableView tableView;

    public AddNewMemberStage(Stage owner, TableView tableView) throws Exception{
        this.tableView = tableView;
        Parent root = SceneController.getInstance().loadLayout(SceneResource.MEMBER_ADD_FXML);
        Scene scene = new Scene(root);
        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
        initOwner(owner);
    }

    public void addMember(Person person){
        tableView.getItems().add(person);
        // TODO : Save person to database here
    }
}