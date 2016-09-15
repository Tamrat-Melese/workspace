package com.mpp.library.ui.controller;

import com.mpp.library.entity.LoggedUser;
import com.mpp.library.entity.UserRole;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable{

    @FXML
    private Tab memberTab;
    @FXML
    private Tab bookTab;
    @FXML
    private Tab checkoutTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            Parent bookTabLayout = SceneController.getInstance().loadLayout(SceneResource.BOOK_SCENE_FXML);
            bookTab.setContent(bookTabLayout);
            
            Parent memberTabLayout = SceneController.getInstance().loadLayout(SceneResource.MEMBER_VIEW_FXML);
            memberTab.setContent(memberTabLayout);
            
            Parent checkoutTabLayout = SceneController.getInstance().loadLayout(SceneResource.CHECKOUT_BOOK_FXML);
            checkoutTab.setContent(checkoutTabLayout);
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
