package com.poc.book.info.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.poc.book.info.exception.BookNotFoundException;
import com.poc.book.info.exception.NoDataFoundException;
import com.poc.book.info.model.Book;
import com.poc.book.info.model.BookDetailsAndMessage;
import com.poc.book.info.model.BookRentDateDetails;
import com.poc.book.info.repository.BookRepository;


@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
	
	@Mock
	private BookRepository repo;
	
	@InjectMocks
	BookServiceImpl bookServiceImpl;
	
	
	Book book=new Book();
	List<Book> findAll = new ArrayList<Book>();
	Optional<Book> books=  Optional.of(book);
	
	
	@BeforeEach
	void setUp(){
		book.setBookId(1);
		book.setBookName("something I never told you");
		book.setAuthorName("Shravya Bhinde");
		book.setBookDescription("love story");
		book.setGenre("non-fiction");
		findAll.add(book);
		long bookId = book.getBookId();
	}
	
	
	@Test
	void testSaveBook() {
		String mess = "book details added successfully with id: "+book.getBookId();
		when(repo.save(Mockito.any())).thenReturn(book);
		String addBook = bookServiceImpl.saveBook(book);
		assertNotNull(addBook);
		assertEquals(mess, addBook);
		
	}

	@Test
	void testGetAllBooks() {
		when(repo.findAll()).thenReturn(findAll);
		List<Book> addBook = bookServiceImpl.getAllBooks();
		assertNotNull(addBook);
		assertEquals(findAll, addBook);

	}
	
	@Test
	void testGetAllBooksException() {
		List<Book> findAllEmpty = new ArrayList<Book>();
		when(repo.findAll()).thenReturn(findAllEmpty);
		assertThrows(NoDataFoundException.class,() -> {
			bookServiceImpl.getAllBooks();
		});

	}

	@Test
	void testGetBookById() {
		when(repo.findById(Mockito.any())).thenReturn(books);
		Book bookById = bookServiceImpl.getBookById(book.getBookId());
		assertNotNull(bookById);
		assertEquals(book, bookById);
	}
	
	@Test
	void testGetBookByIdException() {
		assertThrows(BookNotFoundException.class,() -> {
			bookServiceImpl.getBookById(1234L);
		});
	} 
	

	@Test
	void testDeleteBook() {
		String del = "book deleted with id : " +book.getBookId();
		when(repo.existsById(Mockito.any())).thenReturn(true);
		String deleteBook = bookServiceImpl.deleteBook(book.getBookId());
		verify(repo, times(1)).deleteById(book.getBookId());
		assertEquals(del, deleteBook);
		assertNotNull(deleteBook);
	}
	
	@Test
	void testDeleteBookException() {
		when(repo.existsById(Mockito.any())).thenReturn(false);
		assertThrows(BookNotFoundException.class,() -> {
			bookServiceImpl.deleteBook(book.getBookId());
		});
	}
	

	@Test
	void testUpdateBook() {
		when(repo.findById(Mockito.any())).thenReturn(books);
		when(repo.save(book)).thenReturn(book);
	    Book updateBook = bookServiceImpl.updateBook(book, book.getBookId());
		assertNotNull(updateBook);
		assertEquals(book, updateBook);

	}

	@Test
	void testGetBooksByGenre() {
		String mes = "book with "+book.getGenre()+" is present";
		when(repo.findByGenre(book.getGenre())).thenReturn(findAll);
		BookDetailsAndMessage booksByGenre = bookServiceImpl.getBooksByGenre(book.getGenre());
		assertNotNull(booksByGenre);
		assertEquals(mes,booksByGenre.getMessage());
	}
	
	@Test
	void testGetBooksByGenreExecption() {
		String mes = "book with "+book.getGenre() +" is not found";
		BookDetailsAndMessage booksByGenre = bookServiceImpl.getBooksByGenre(book.getGenre());
		assertNotNull(booksByGenre);
		assertEquals(mes,booksByGenre.getMessage());
	}

//	@Test
//	void testAddBookToCart() {
//		BookRentDateDetails bookRentDateDetails =  new BookRentDateDetails();
//		when(repo.findByBookName(bookRentDateDetails.getBookName())).thenReturn(book);
//		BookRentDateDetails addBookToCart = bookServiceImpl.addBookToCart(bookRentDateDetails.getBookName());
//		assertNotNull(addBookToCart);
//	}
}
