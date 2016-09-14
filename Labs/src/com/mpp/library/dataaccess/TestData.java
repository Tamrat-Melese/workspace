package com.mpp.library.dataaccess;

import com.mpp.library.entity.Author;
import com.mpp.library.entity.Book;
import com.mpp.library.entity.BookCopy;
import com.mpp.library.util.Constant;

public class TestData {
    private static TestData instanse = new TestData();
    private static DataAccess<String, Book> books = new DataAccessImpl<>();
    static {
        Book b1 = new Book("Book 1", "123456");
        Author a1 = new Author("Clark", "Ken", "He is the Supperman");
        b1.addAuthor(a1);

        BookCopy bc1 = new BookCopy(b1, 21, "1111111");
        bc1.setAvailability(Constant.UNAVAILABLE);
        b1.addBookCopy(bc1);
        BookCopy bc2 = new BookCopy(b1, 7, "2222222");
        b1.addBookCopy(bc2);


        Book b2 = new Book("Book 2", "654321");
        Author a2 = new Author("An", "Nguyen", "He is the one code this project");
        b2.addAuthor(a2);
        b2.addAuthor(a1);

        BookCopy bc3 = new BookCopy(b2, 21, "3333333");
        b2.addBookCopy(bc3);

        books.add(b1.getISBN(), b1);
        books.add(b2.getISBN(), b2);
    }

    private TestData(){}

    public static TestData getInstanse() {
        return instanse;
    }

    public void addNewBookCopy(Book book, BookCopy bookCopy){
        book.addBookCopy(bookCopy);
    }

    public Book getBookByISBN(String ISBN){
        return books.get(ISBN);
    }

    public DataAccess<String, Book> getBooks(){
        return books;
    }
}
