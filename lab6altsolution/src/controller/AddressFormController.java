package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by anthony on 9/11/16.
 */
public class AddressFormController {
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfStreet;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfState;
    @FXML
    private TextField tfZip;

    @FXML
    private void printAddress(ActionEvent event){
        System.out.println(tfName.getText() + "\n" +
                tfStreet.getText() + "\n" +
                tfCity.getText() + ", " + tfState.getText() + " " + tfZip.getText());
    }
}
