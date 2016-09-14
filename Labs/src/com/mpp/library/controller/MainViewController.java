package com.mpp.library.controller;

import com.mpp.library.entity.UserRole;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable{

    @FXML
    private TabPane tabMenu;

    @FXML
    private Tab memberTab;
    @FXML
    private Tab bookTab;
    @FXML
    private Tab checkoutTab;
    @FXML
    private GridPane memberLayout;
    @FXML
    private GridPane bookLayout;
    @FXML
    private GridPane checkoutLayout;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            Parent bookTabLayout = SceneController.getInstance().loadLayout(SceneResource.BOOK_SCENE_FXML);
            bookLayout.add(bookTabLayout, 0, 0);
        } catch (Exception e){

        }

        if(LoggedUser.getInstance().getPerson().getRoles().contains(UserRole.ADMINISTRATOR)){
            bookTab.setDisable(false);
            memberTab.setDisable(false);
        }
        if(LoggedUser.getInstance().getPerson().getRoles().contains(UserRole.LIBRARYAN)){
            checkoutTab.setDisable(false);
        }
    }
}
