package com.poc.book.info.exception;



public class BookExists  extends RuntimeException{
	private static final long serialVersionUID=1;

	public  BookExists(String ms) {
		super(ms);
	}

}