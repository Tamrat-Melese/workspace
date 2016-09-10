import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by anthony on 9/10/16.
 */
public class Question2 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label lInput = new Label("Input");
        lInput.setFont(new Font(10));
        TextField tfInput = new TextField();
        Label lOutput = new Label("Output");
        lOutput.setFont(new Font(10));
        TextField tfOutput = new TextField();

        VBox secondCol = new VBox();
        secondCol.setAlignment(Pos.CENTER_LEFT);
        secondCol.getChildren().add(lInput);
        secondCol.getChildren().add(tfInput);
        secondCol.getChildren().add(lOutput);
        secondCol.getChildren().add(tfOutput);

        Button bCount = new Button("Count Letters");
        bCount.setAlignment(Pos.BASELINE_LEFT);
        bCount.setMaxWidth(Double.MAX_VALUE);
        bCount.setOnAction(event -> tfOutput.setText(countLetters(tfInput)));

        Button bRevert = new Button("Revert Letters");
        bRevert.setAlignment(Pos.BASELINE_LEFT);
        bRevert.setMaxWidth(Double.MAX_VALUE);
        bRevert.setOnAction(event -> tfOutput.setText(revertLetters(tfInput)));

        Button bRemove = new Button("Remove Duplicates");
        bRemove.setAlignment(Pos.BASELINE_LEFT);
        bRemove.setMaxWidth(Double.MAX_VALUE);
        bRemove.setOnAction(event -> tfOutput.setText(removeDuplicates(tfInput)));

        VBox firstCol = new VBox(10);
        firstCol.setAlignment(Pos.CENTER_LEFT);
        firstCol.getChildren().add(bCount);
        firstCol.getChildren().add(bRevert);
        firstCol.getChildren().add(bRemove);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(20);
        root.setPadding(new Insets(10,40, 40, 40));
        root.add(firstCol, 0, 0);
        root.add(secondCol, 1, 0);

        Scene scene = new Scene(root);
        primaryStage.setTitle("String Utility");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String countLetters(TextField tf){
        return String.valueOf(tf.getText().length());
    }

    private String revertLetters(TextField tf){
        return new StringBuilder(tf.getText()).reverse().toString();
    }

    private String removeDuplicates(TextField tf){
        char[] chars = tf.getText().toCharArray();
        Set<Character> str = new LinkedHashSet<>();
        for (char c : chars) {
            str.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : str) {
            sb.append(character);
        }
        return sb.toString();
    }
}
