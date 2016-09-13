package com.mpp.library.role;

import com.mpp.library.entity.Book;
import com.mpp.library.entity.BookCopy;

public class AdministratorImpl implements AdministratorRole{
    @Override
    public AdministratorRole addBookCopyToBook(BookCopy bookCopy, Book book) {

        return this;
    }
}
