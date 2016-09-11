import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by anthony on 9/11/16.
 */
public class StringUtility extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/StringUtility.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("String Utility");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
