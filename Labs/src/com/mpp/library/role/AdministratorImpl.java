package com.mpp.library.role;

import com.mpp.library.model.Book;
import com.mpp.library.model.BookCopy;

public class AdministratorImpl implements AdministratorRole{
    @Override
    public AdministratorRole addBookCopyToBook(BookCopy bookCopy, Book book) {

        return this;
    }
}
