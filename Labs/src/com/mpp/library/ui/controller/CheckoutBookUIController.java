package com.mpp.library.ui.controller;

import com.mpp.library.controller.CheckoutBookController;
import com.mpp.library.entity.CheckoutRecord;
import com.mpp.library.ui.model.CheckoutEntryModel;
import com.mpp.library.ui.model.adapter.CheckoutEntryAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CheckoutBookUIController {

	private CheckoutBookController checkoutController = CheckoutBookController.getInstance();

	@FXML
	private TextField txtMemberID;
	@FXML
	private Text txtName;
	@FXML
	private Text txtAddress;
	@FXML
	private Text txtCheckoutDate;
	@FXML
	private TextField txtISBN;

	@FXML
	private TableColumn titleColumn;

	@FXML
	private TableView<CheckoutEntryModel> checkoutEntryTable;

	private ObservableList<CheckoutEntryModel> values = FXCollections.observableArrayList();

	public CheckoutBookUIController() {
	}

	 @FXML
	 private void initialize() {
		 titleColumn.prefWidthProperty().bind(checkoutEntryTable.widthProperty().subtract(310));

		 values.addAll(CheckoutEntryAdapter.toCheckoutEntryModels(new CheckoutRecord().getRecordEntries()));
			checkoutEntryTable.setItems(values);
	 }

	@FXML
	private void checkoutBook(ActionEvent event) {
		System.out.println("checkoutBooks");

		CheckoutRecord checkoutRecord;
		try {
			checkoutRecord = checkoutController.checkoutBooks(txtMemberID.getText(), txtISBN.getText());
			values.addAll(CheckoutEntryAdapter.toCheckoutEntryModels(checkoutRecord.getRecordEntries()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
