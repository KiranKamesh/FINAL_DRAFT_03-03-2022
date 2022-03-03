package com.mouritech.onlinebookstoremanagement.service;

import com.mouritech.onlinebookstoremanagement.entity.Book;
import com.mouritech.onlinebookstoremanagement.exception.BookNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouritech.onlinebookstoremanagement.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book insertBook(Book newBook) {
		return bookRepository.save(newBook);
	}

	@Override
	public List<Book> showAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book showBookByISBN(Long bookISBN) throws BookNotFoundException {

		return bookRepository.findById(bookISBN)
				.orElseThrow(() -> new BookNotFoundException("The following book is not found"));
	}

	@Override
	public Book updateBookByISBN(Long bookISBN, Book book) throws BookNotFoundException{
		Book exisitingBook = bookRepository.findById(bookISBN)
				.orElseThrow(() -> new BookNotFoundException("The following book is not found"));
		exisitingBook.setAuthor(book.getAuthor());
		exisitingBook.setBookName(book.getBookName());
		exisitingBook.setNoOfCopies(book.getNoOfCopies());
		exisitingBook.setPrice(book.getPrice());
		return bookRepository.save(exisitingBook);
	}

	@Override
	public void deleteBookByISBN(Long bookISBN) throws BookNotFoundException{
		Book existingBook = bookRepository.findById(bookISBN).orElseThrow(() -> new BookNotFoundException("The following book is not found"));
		bookRepository.delete(existingBook);

	}

}
