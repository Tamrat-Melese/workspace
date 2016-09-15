package com.mpp.library;

import com.mpp.library.controller.BookController;
import com.mpp.library.controller.CheckoutBookController;
import com.mpp.library.controller.LoginController;
import com.mpp.library.controller.UserController;
import com.mpp.library.dataaccess.TestData;
import com.mpp.library.entity.CheckoutRecord;
import com.mpp.library.entity.Person;
import com.mpp.library.entity.UserAccount;
import com.mpp.library.ui.controller.SceneController;
import com.mpp.library.ui.controller.SceneResource;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LibraryApplication extends Application{

    public static void main(String[] args) {
    	initialize();
    	
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Library Management System");
        //Person person = new Person("123","asdfsad","asdfasdf",new Address("","","",""),"123124");
        //person.getRoles().add(UserRole.ADMINISTRATOR);
        //person.getRoles().add(UserRole.LIBRARYAN);
        //person.getRoles().add(UserRole.MEMBER);
        //LoggedUser.getInstance().setPerson(person);

        Parent root = SceneController.getInstance().loadLayout(SceneResource.LOGIN_SCENE_FXML);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

	public static void initialize() {
		TestData testData = new TestData();

		// create copies
		testData.bookData();
		
		// create persons
		UserController userController = UserController.getInstance();
		for (Person person : testData.persons) {
			userController.save(person);
		}

		// create user
		LoginController loginController = LoginController.getInstance();
		for (UserAccount users : testData.userAccounts) {
			loginController.save(users);
		}

		// create books
		// TODO
		BookController bookController = BookController.getInstance();
//		for (Book book : testData.allBooks) {
//			bookController.save(book);
//		}
		
		// create CheckoutEntry
		CheckoutBookController checkoutBookController = CheckoutBookController.getInstance();
		for (CheckoutRecord checkoutRecord : testData.allRecords) {
			checkoutBookController.save(checkoutRecord);
		}
	}


}
