package com.mpp.library.ui.model.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mpp.library.entity.BookCopy;
import com.mpp.library.entity.CheckoutRecordEntry;
import com.mpp.library.ui.model.CheckoutEntryModel;

public class CheckoutEntryAdapter {
	
	public static CheckoutEntryModel toCheckoutEntryModel(CheckoutRecordEntry recordEntry) {
		BookCopy bookCopy = recordEntry.getBookCopy();
		CheckoutEntryModel checkoutEntryModel= new CheckoutEntryModel (
				recordEntry.getID(), 
				bookCopy.getBook().getTitle(), 
				bookCopy.getBook().getISBN(), 
				recordEntry.getCheckoutDate().toString(), 
				recordEntry.getDueDate().toString()
		);
		
		return checkoutEntryModel;
	}
	
	public static List<CheckoutEntryModel> toCheckoutEntryModels(Collection<CheckoutRecordEntry> recordEntries) {
		List<CheckoutEntryModel> entryModels = new ArrayList<>(recordEntries.size());
		
		for (CheckoutRecordEntry recordEntry : recordEntries) {
			CheckoutEntryModel checkoutEntryModel = toCheckoutEntryModel(recordEntry);
			entryModels.add(checkoutEntryModel);
		}
		
		return entryModels;
	}
	
//	public static CheckoutRecordEntry toCheckoutRecordEntry(CheckoutEntryModel entryModel){
//		CheckoutRecordEntry checkoutRecordEntry = new CheckoutRecordEntry(bookCopy, checkoutDate, dueDate);
//		
//		return checkoutRecordEntry;
//	}

}
