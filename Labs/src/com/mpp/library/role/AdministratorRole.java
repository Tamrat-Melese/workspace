package com.mpp.library.role;

import com.mpp.library.model.Book;
import com.mpp.library.model.BookCopy;

public interface AdministratorRole extends UserRole {
    public AdministratorRole addBookCopyToBook(BookCopy bookCopy, Book b);
    //public void addMember();
    //public void editMember();
}
