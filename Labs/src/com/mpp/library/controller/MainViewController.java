package com.mpp.library.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable{

    private Stage currentStage;

    @FXML
    private TabPane tabMenu;
    @FXML
    private Tab memberTab;
    @FXML
    private Tab bookTab;
    @FXML
    private Tab checkoutTab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentStage = (Stage) memberTab.getContent().getScene().getWindow();
        boolean c = true;
        if(c) tabMenu.getTabs().get(0).getContent().setVisible(false);
    }
}
