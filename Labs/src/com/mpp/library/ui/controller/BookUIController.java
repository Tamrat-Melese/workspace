package com.mpp.library.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.mpp.library.entity.Book;
import com.mpp.library.stage.AddBookCopyStage;
import com.mpp.library.ui.view.FXHelper;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class BookUIController implements Initializable{
    @FXML
    private TableView bookTableView;
    @FXML
    private TableView copyTableView;

    @FXML
    private TableColumn titleColumn;
    @FXML
    private TableColumn authorsColumn;

    @FXML
    private Button addBookCopyButton;
    @FXML
    private TextField tfSeach;

    @FXML
    private Text tBookCount;
    @FXML
    private Text tBookCopyCount;

    private SortedList<Book> sortedData;
    private Book selectedBook;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setClickableRowForBookTable();

        titleColumn.prefWidthProperty().bind(bookTableView.widthProperty().subtract(202).divide(2));
        authorsColumn.prefWidthProperty().bind(bookTableView.widthProperty().subtract(202).divide(2));



        setBookTableData();

        BooleanBinding activate = Bindings.isEmpty(bookTableView.getSelectionModel().getSelectedItems());
        addBookCopyButton.disableProperty().bind(activate);

        tBookCount.textProperty().bind(Bindings.size(sortedData).asString());
        tBookCopyCount.textProperty().bind(Bindings.size(copyTableView.getItems()).asString());
    }

    private void setClickableRowForBookTable(){
        bookTableView.setRowFactory(new Callback<TableView<Book>, TableRow<Book>>() {
            @Override
            public TableRow<Book> call(TableView<Book> param) {
                final TableRow<Book> row = new TableRow<>();
                row.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        try {
                            selectedBook = (Book) bookTableView.getItems().get(row.getIndex());

                            FXHelper.updateBookCopyList(copyTableView.getItems(), selectedBook);
                        } catch (IndexOutOfBoundsException e){
                            // Do nothing
                        }
                    }
                });
                return row;
            }
        });
    }

    private void setBookTableData(){
        ObservableList<Book> bookObservableList = FXHelper.getObserverListOfBook();
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Book> filteredData = new FilteredList<>(bookObservableList, book -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        tfSeach.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(book -> {
                // If filter text is empty, display all books.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare ISBN of every book with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (book.getISBN().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }

                return false; // Does not match.
            });
        });
        // 3. Wrap the FilteredList in a SortedList.
        sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(bookTableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        bookTableView.setItems(sortedData);
    }

    @FXML
    private void onClickAdd(ActionEvent event) throws Exception{
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        AddBookCopyStage stage = new AddBookCopyStage(primaryStage, copyTableView, selectedBook);
        stage.show();
    }
}
