package com.poc.book.info.exception;


public class NoDataFoundException extends RuntimeException{
private static final long serialVersionUID=1;

public  NoDataFoundException(String message) {
	super(message);
}
}

