package com.mpp.library.controller;

import com.mpp.library.entity.Book;
import com.mpp.library.entity.BookCopy;

public class BookController extends Controller<Book> {
	
	private static BookController instance = new BookController();
	
	private BookController() {
		super();
	}

	public static BookController getInstance() {
		return instance;
	}

	public Book searchBook(String ISBN) {
		return get(ISBN);
	}

    public BookCopy addBookCopy(Book selectedBook,String copyNumber){
        BookCopy bookCopy = new BookCopy(selectedBook, copyNumber);
        selectedBook.addBookCopy(bookCopy);
        save(selectedBook);
        
        return bookCopy;
    }

    public Book addBook(String ISBN, String title, int borrowDuration){
		Book book = new Book(title, ISBN, borrowDuration);
		save(book);

		return book;
	}
}
