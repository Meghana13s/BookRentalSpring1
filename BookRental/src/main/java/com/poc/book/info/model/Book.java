package com.poc.book.info.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "BookRental")
@AllArgsConstructor
@NoArgsConstructor 
public class Book {
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private long bookId;
	private String bookName;
	private String authorName;
	private String bookDescription;
	private String genre;

}
