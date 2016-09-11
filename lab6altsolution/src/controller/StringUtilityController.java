package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by anthony on 9/11/16.
 */
public class StringUtilityController {
    @FXML
    private TextField tfInput;
    @FXML
    private TextField tfOutput;

    @FXML
    private void countLetters(ActionEvent event){
        tfOutput.setText(String.valueOf(tfInput.getText().length()));
    }

    @FXML
    private void reverseLetters(ActionEvent event){
        tfOutput.setText(new StringBuilder(tfInput.getText()).reverse().toString());
    }

    @FXML
    private void removeDuplicates(ActionEvent event){
        char[] chars = tfInput.getText().toCharArray();
        Set<Character> str = new LinkedHashSet<>();

        for(char c : chars){
            str.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(char c : str){
            sb.append(c);
        }

        tfOutput.setText(sb.toString());
    }
}
