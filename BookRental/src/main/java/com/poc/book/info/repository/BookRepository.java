package com.poc.book.info.repository;

import com.poc.book.info.model.Book;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book,Long> {
	
	public List<Book> findByGenre(String genre);
	
	public Book findByBookName(String bookName);

}
