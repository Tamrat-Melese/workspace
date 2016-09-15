package com.mpp.library.controller;

import com.mpp.library.entity.Book;

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
}
