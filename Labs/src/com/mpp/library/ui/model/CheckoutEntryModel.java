package com.mpp.library.ui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CheckoutEntryModel {

	private String ID;
	private String title;
	private String isbn;
	private String checkoutDate;
	private String dueDate;

	public CheckoutEntryModel(String ID, String title, String isbn, String checkoutDate, String dueDate) {
		super();
		this.ID = ID;
		this.title = title;
		this.isbn = isbn;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public StringProperty titleProperty() {
		return new SimpleStringProperty(title);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public StringProperty isbnProperty() {
		return new SimpleStringProperty(isbn);
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public StringProperty checkoutDateProperty() {
		return new SimpleStringProperty(checkoutDate);
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public StringProperty dueDateProperty() {
		return new SimpleStringProperty(dueDate);
	}

}
