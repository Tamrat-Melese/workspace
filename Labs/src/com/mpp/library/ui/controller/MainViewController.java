package com.mpp.library.ui.controller;

import com.mpp.library.entity.LoggedUser;
import com.mpp.library.entity.UserRole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable{

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab memberTab;
    @FXML
    private Tab bookTab;
    @FXML
    private Tab checkoutTab;

    @FXML
    private Label welcomeText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcomeText.setText("Welcome, " + LoggedUser.getInstance().getPerson().getFirstName());
        LoggedUser.getInstance().setMemberTab(memberTab);
        LoggedUser.getInstance().setBookTab(bookTab);
        LoggedUser.getInstance().setCheckoutTab(checkoutTab);
        try{
            LoggedUser.getInstance().loadMemberTab();
            LoggedUser.getInstance().loadBookTab();
            LoggedUser.getInstance().loadCheckoutTab();
        } catch (Exception e){
        }

        if(LoggedUser.getInstance().getPerson().getRoles().contains(UserRole.LIBRARYAN)){
            checkoutTab.setDisable(false);
            tabPane.getSelectionModel().select(checkoutTab);
        }
        if(LoggedUser.getInstance().getPerson().getRoles().contains(UserRole.ADMINISTRATOR)){
            bookTab.setDisable(false);
            memberTab.setDisable(false);
            tabPane.getSelectionModel().select(memberTab);
        }
    }

    @FXML
    private void updateBookTab() throws Exception {
        LoggedUser.getInstance().loadBookTab();
    }

    @FXML
    private void logout(ActionEvent event) throws Exception {
        Stage stage = new Stage();
        stage.setTitle(SceneResource.APP_NAME);

        Parent root = SceneController.getInstance().loadLayout(SceneResource.LOGIN_SCENE_FXML);

        Scene scene = new Scene(root);
        //String css = getClass().getResource("ui/view/application.css").toExternalForm();
        //scene.getStylesheets().add(css);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        LoggedUser.getInstance().setPerson(null);
        primaryStage.close();

    }
}
