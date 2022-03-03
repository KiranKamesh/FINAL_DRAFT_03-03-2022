package com.mouritech.onlinebookstoremanagement.controller;

import com.mouritech.onlinebookstoremanagement.entity.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mouritech.onlinebookstoremanagement.entity.Customer;
import com.mouritech.onlinebookstoremanagement.exception.BookNotFoundException;
import com.mouritech.onlinebookstoremanagement.exception.CustomerNotFoundException;
import com.mouritech.onlinebookstoremanagement.service.BookService;
import com.mouritech.onlinebookstoremanagement.service.CustomerService;

@RestController
@RequestMapping("book/api/v1")
public class BookController {

	@Autowired
	BookService bookService;



	@PostMapping("/book")
	public Book saveBook(@RequestBody Book newBook) {
		return bookService.insertBook(newBook);
	}

	@GetMapping("/book")
	public List<Book> getAllBooks() {
		return bookService.showAllBooks();

	}

	// get a book by id
	@GetMapping("book/{bisbn}")
	public Book showBookByISBN(@PathVariable("bisbn") Long bookISBN) throws BookNotFoundException{
	return bookService.showBookByISBN(bookISBN);
	}

	// update a customer
	@PutMapping("book/{bisbn}")
	public Book updateBookByISBN(@PathVariable("bisbn") Long bookISBN ,@RequestBody Book book) throws BookNotFoundException{
      return bookService.updateBookByISBN(bookISBN,book);
	}
	
	@DeleteMapping("book/{bisbn}")
	public String deleteBookByISBN(@PathVariable("bisbn") Long bookISBN)
			throws BookNotFoundException {
		bookService.deleteBookByISBN(bookISBN);
		return "book deleted";
		
	}
	
	
}
