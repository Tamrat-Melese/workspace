package com.mpp.library.role;

import com.mpp.library.entity.Book;
import com.mpp.library.entity.BookCopy;

public interface AdministratorRole extends UserRole {
    public AdministratorRole addBookCopyToBook(BookCopy bookCopy, Book b);
    //public void addMember();
    //public void editMember();
}
