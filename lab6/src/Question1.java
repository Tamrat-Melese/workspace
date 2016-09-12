import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Question1 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create the 1st grid
        GridPane gp1 = new GridPane();
        gp1.setPadding(new Insets(10));
        gp1.setHgap(10);
        gp1.setAlignment(Pos.CENTER);
        // Name
        Label lName = new Label("Name");
        TextField tfName = new TextField();
        gp1.add(lName, 0, 0);
        gp1.add(tfName, 0, 1);
        // Street
        Label lStreet = new Label("Street");
        TextField tfStreet = new TextField();
        gp1.add(lStreet, 1, 0);
        gp1.add(tfStreet, 1, 1);
        // City
        Label lCity = new Label("City");
        TextField tfCity = new TextField();
        gp1.add(lCity, 2, 0);
        gp1.add(tfCity, 2, 1);

        // Create 2nd grid
        GridPane gp2 = new GridPane();
        gp2.setPadding(new Insets(10));
        gp2.setHgap(10);
        gp2.setAlignment(Pos.CENTER);
        // State
        Label lState = new Label("State");
        TextField tfState = new TextField();
        gp2.add(lState, 0, 0);
        gp2.add(tfState, 0, 1);
        // Zip
        Label lZip = new Label("Zip");
        TextField tfZip = new TextField();
        gp2.add(lZip, 1, 0);
        gp2.add(tfZip, 1, 1);

        Button bSubmit = new Button("Submit");
        bSubmit.setOnAction(event -> {
            System.out.println(tfName.getText() + "\n" +
                    tfStreet.getText() + "\n" +
                    tfCity.getText() + ", " + tfState.getText() + " " + tfZip.getText());
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30,0,10,0));
        vBox.getChildren().add(bSubmit);

        // Create 3rd grid
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.add(gp1, 0, 0);
        root.add(gp2, 0, 1);
        root.add(vBox, 0, 2);

        // Add root to Scene
        Scene scene = new Scene(root);
        primaryStage.setTitle("Address Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
