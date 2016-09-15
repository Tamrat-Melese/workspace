package com.mpp.library.entity;

import com.mpp.library.ui.controller.SceneController;
import com.mpp.library.ui.controller.SceneResource;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

public class LoggedUser {
    private static LoggedUser instance;

    private Person person;
    private Tab memberTab;
    private Tab bookTab;
    private Tab checkoutTab;

    private LoggedUser(){}

    public static LoggedUser getInstance(){
        if(instance == null) instance = new LoggedUser();
        return instance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;

    }

    public void setMemberTab(Tab memberTab) {
        this.memberTab = memberTab;
    }

    public void setBookTab(Tab bookTab) {
        this.bookTab = bookTab;
    }

    public void setCheckoutTab(Tab checkoutTab) {
        this.checkoutTab = checkoutTab;
    }

    public void loadMemberTab() throws Exception {
        loadTab(memberTab, SceneResource.MEMBER_VIEW_FXML);
    }
    public void loadBookTab() throws Exception {
        loadTab(bookTab, SceneResource.BOOK_SCENE_FXML);
    }
    public void loadCheckoutTab() throws Exception{
        loadTab(checkoutTab, SceneResource.CHECKOUT_BOOK_FXML);
    }

    private void loadTab(Tab tab, String fxml) throws Exception{
        Parent layout = SceneController.getInstance().loadLayout(fxml);
        tab.setContent(layout);
    }
}
