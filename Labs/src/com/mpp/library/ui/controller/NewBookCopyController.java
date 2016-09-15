package com.mpp.library.ui.controller;

import com.mpp.library.stage.AddBookCopyStage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewBookCopyController implements Initializable{
    @FXML
    private TextField tfCopyNumber;
    @FXML
    private TextField tfBorrowDuration;

    @FXML
    private void onClickAdd(ActionEvent event){
        AddBookCopyStage stage = (AddBookCopyStage) ((Node)event.getSource()).getScene().getWindow();

        stage.addBookCopy(tfCopyNumber.getText(), tfBorrowDuration.getText());
        stage.close();
    }

    @FXML
    private void onClickCancel(ActionEvent event){
        AddBookCopyStage stage = (AddBookCopyStage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tfBorrowDuration.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    tfBorrowDuration.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
