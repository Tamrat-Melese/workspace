package com.mpp.library;

import com.mpp.library.controller.LoggedUser;
import com.mpp.library.controller.SceneController;
import com.mpp.library.controller.SceneResource;
import com.mpp.library.entity.Address;
import com.mpp.library.entity.Person;
import com.mpp.library.entity.UserRole;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LibraryApplication extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Library Management System");
        Person person = new Person("123","asdfsad","asdfasdf",new Address("","","",""),"123124");
        person.getRoles().add(UserRole.ADMINISTRATOR);
        //person.getRoles().add(UserRole.LIBRARYAN);
        person.getRoles().add(UserRole.MEMBER);
        LoggedUser.getInstance().setPerson(person);

        Parent root = SceneController.getInstance().loadLayout(SceneResource.MAIN_VIEW_FXML);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
