package com.mpp.library.controller;

import java.time.LocalDate;

import com.mpp.library.entity.Book;
import com.mpp.library.entity.BookCopy;
import com.mpp.library.entity.CheckoutRecord;
import com.mpp.library.entity.CheckoutRecordEntry;
import com.mpp.library.entity.Person;

public final class CheckoutBookController extends Controller<CheckoutRecord> {

	private static CheckoutBookController instance = new CheckoutBookController();

	private CheckoutBookController() {
		super();
	}

	public static CheckoutBookController getInstance() {
		return instance;
	}

	public CheckoutRecord checkoutBooks(String memberID, String isbn) throws Exception {
		System.out.println("controller checkoutBooks");
		UserController userController = UserController.getInstance();
		Person member = userController.searchMember(memberID);
		
		if (member == null){
			throw new Exception("Libray Member not found with ID= "+ memberID);
		}
		
		BookController bookController = BookController.getInstance();
		Book book = bookController.searchBook(isbn);
		
		if (book== null){
			throw new Exception("Book not found with ISBN= "+ isbn);
		}
		if (!book.isAvailabile()){
			throw new Exception("BookCopy not available with ISBN= "+ isbn);
		}
		

		CheckoutRecord checkoutRecord = new CheckoutRecord(getUniqueID(), member);
		member.addCheckoutRecord(checkoutRecord);
		BookCopy bookCopy = book.getNextAvailableCopy();
		
		LocalDate checkoutDate = LocalDate.of(2016,9,14);
		LocalDate dueDate = checkoutDate.plusDays(book.getBorrowDuration());
		checkoutRecord.addRecordEntry(new CheckoutRecordEntry(
				bookCopy, 
				checkoutDate, 
				dueDate
		));
		
		
		reserveBookCopy(bookCopy);
		
		save(checkoutRecord);
		
		System.out.println(checkoutRecord);
		checkoutRecord = get(member.getID());
		return checkoutRecord;
	}

	private void reserveBookCopy(BookCopy bookCopy) {
		bookCopy.setAvailability(false);
	}
}
