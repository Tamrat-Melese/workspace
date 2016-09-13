package com.mpp.library.controller;

import com.mpp.library.util.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class BookController implements Initializable{
    @FXML private TableView tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setItems(Database.data);
    }
}
