package com.poc.book.info.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailsAndMessage {
	
	private String message;
	private List<Book> books;

}
