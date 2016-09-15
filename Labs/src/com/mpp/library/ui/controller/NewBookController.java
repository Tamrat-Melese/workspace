package com.mpp.library.ui.controller;

import com.mpp.library.stage.AddBookStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewBookController implements Initializable{
    @FXML private TextField tfISBN;
    @FXML private TextField tfTitle;
    @FXML private TextField tfBorrowDuration;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML private void onClickCancel(ActionEvent event){
        AddBookStage stage = (AddBookStage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML private void onClickAdd(ActionEvent event) throws Exception{
        AddBookStage stage = (AddBookStage) ((Node)event.getSource()).getScene().getWindow();

        stage.addBook(tfISBN.getText(),
                tfTitle.getText(),
                tfBorrowDuration.getText().isEmpty() ? 0 : Integer.valueOf(tfBorrowDuration.getText()));
        stage.close();
    }
}
