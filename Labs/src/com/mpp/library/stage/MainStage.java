package com.mpp.library.stage;

import com.mpp.library.ui.controller.SceneController;
import com.mpp.library.ui.controller.SceneResource;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainStage extends Stage{

    public MainStage() throws Exception{
        super();
        setTitle(SceneResource.APP_NAME);
        Parent root = SceneController.getInstance().loadLayout(SceneResource.MAIN_VIEW_FXML);
        Scene scene = new Scene(root, 800, 550);
        setScene(scene);
    }
}
