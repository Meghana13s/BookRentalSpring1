package com.poc.book.info.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.client.MongoDatabase;
import com.poc.book.info.model.Book;
import com.poc.book.info.model.BookRentDateDetails;

public interface BookRentDateDetailsRepository extends  MongoRepository<BookRentDateDetails,Long> {

}
