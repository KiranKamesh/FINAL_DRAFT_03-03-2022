package com.mouritech.onlinebookstoremanagement.service;

import com.mouritech.onlinebookstoremanagement.entity.Book;
import com.mouritech.onlinebookstoremanagement.exception.BookNotFoundException;

import java.util.List;

public interface BookService {

	Book insertBook(Book newBook);

	List<Book> showAllBooks();

	Book showBookByISBN(Long bookISBN) throws BookNotFoundException;

	Book updateBookByISBN(Long bookISBN, Book book) throws BookNotFoundException;

	void deleteBookByISBN(Long bookISBN) throws BookNotFoundException;

}
