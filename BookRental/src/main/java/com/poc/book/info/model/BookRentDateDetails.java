package com.poc.book.info.model;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor 
@Document(collection = "BookRentalDetails")
public class BookRentDateDetails {
	
	private String bookName;
	private String authorName;
	private LocalDate borrowedDate;
	private LocalDate dueDate;

}
