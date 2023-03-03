package com.poc.book.info.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.poc.book.info.exception.BookNotFoundExceptions;
import com.poc.book.info.model.Book;
import com.poc.book.info.model.BookDetailsAndMessage;
import com.poc.book.info.model.BookRentDateDetails;
import com.poc.book.info.service.BookServiceImpl;
import com.poc.book.info.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@Slf4j

public class BookController {

	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@Autowired
	private BookServiceImpl service;

	@PostMapping("/addBo?k")
	public ResponseEntity<String> saveBook(@RequestBody Book book) {

		book.setBookId(sequenceGeneratorService.generateSequence(book.SEQUENCE_NAME));
		String saveBook = service.saveBook(book);
		log.info("The book got saved in the repo for the book name" + saveBook);
		return new ResponseEntity<String>("book details added successfully with id " + book.getBookId(),
				HttpStatus.CREATED);

	}
	
	@PostMapping("/addBookToCart/{bookName}")
	public ResponseEntity<BookRentDateDetails> addBookToCart(@PathVariable String bookName) {
		BookRentDateDetails addCart = service.addBookToCart(bookName);
		log.info("The book got saved in the cart for the book name " + addCart.getBookName());
		return new ResponseEntity<BookRentDateDetails>(addCart, HttpStatus.CREATED);
	}

//	@PostMapping("/addCart/{id}")
//	public ResponseEntity<BookRentDateDetails> addCart(@PathVariable long id) {
//		BookRentDateDetails addCart = service.addCart(id);
//		log.info("The book got saved in the cart for the book name " + addCart.getBookName());
//		return new ResponseEntity<BookRentDateDetails>(addCart, HttpStatus.CREATED);
//	}
	
//	@PostMapping("/addCart")
//	public ResponseEntity<List<BookRentDateDetails>> addCart(@RequestBody @Valid User user) {
//		List<BookRentDateDetails> addCart = service.addCart(user);
////		log.info("The book got saved in the cart for the book name " + addCart.getBookName());
//		return new ResponseEntity<List<BookRentDateDetails>>(addCart, HttpStatus.CREATED);
//	}

	@GetMapping("/findAllBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> listOfAllBooks = service.getAllBooks();
		return new ResponseEntity<List<Book>>(listOfAllBooks, HttpStatus.OK);
	}

	@GetMapping("/getBookById/{id}")
	public ResponseEntity<Book> getBook(@PathVariable long id) {
		Book bookid = service.getBookById(id);
		return new ResponseEntity<Book>(bookid, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable long id) {
		String bookDelete = service.deleteBook(id);
		return new ResponseEntity<String>(bookDelete, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable long id) {
		Book bookupdate = service.updateBook(book, id);
		return new ResponseEntity<Book>(bookupdate, HttpStatus.CREATED);

	}

	@GetMapping("/getbygenre/{Genre}")
	public ResponseEntity<BookDetailsAndMessage> getBooksByGenre(@PathVariable String Genre) throws BookNotFoundExceptions {
		BookDetailsAndMessage listOfAllBooks = service.getBooksByGenre(Genre);
		return new ResponseEntity<BookDetailsAndMessage>(listOfAllBooks, HttpStatus.OK);

	}
}
