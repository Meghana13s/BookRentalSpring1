package com.poc.book.info.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.book.info.exception.BookExists;
import com.poc.book.info.exception.BookNotFoundException;
import com.poc.book.info.exception.NoDataFoundException;
import com.poc.book.info.model.Book;
import com.poc.book.info.model.BookDetailsAndMessage;
import com.poc.book.info.model.BookRentDateDetails;



@Service
public interface BookService {
	
	public String saveBook(Book book);
	
	public List<Book> getAllBooks() throws NoDataFoundException;
	
	public Book getBookById(long id) throws BookNotFoundException;
	
	public String deleteBook(long id) throws BookNotFoundException;
	
	public Book updateBook(Book book,long id);
	
	public BookDetailsAndMessage getBooksByGenre(String Genre);
	
	public BookRentDateDetails addBookToCart(String bookName);
	
//	public List<BookRentDateDetails> addCart(User user);
	
//	public BookRentDateDetails addCart(long id);


}
