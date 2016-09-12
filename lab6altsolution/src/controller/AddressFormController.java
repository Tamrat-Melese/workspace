package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
        StringBuilder builder = new StringBuilder();
		builder.append(tfName.getText()).append("\n");
		builder.append(tfStreet.getText()).append("\n");
		builder.append(tfCity.getText()).append(tfState.getText());
		builder.append(", ").append(tfZip.getText());
		System.out.println(builder.toString());
    }
}
