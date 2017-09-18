package com.aspire.service.exception;

public class AddBodyException extends RuntimeException {

	private static final long serialVersionUID = 2383004581011384505L;

	public AddBodyException() {
		
	}

	public AddBodyException(String message) {
		super(message);
		
	}

	public AddBodyException(Throwable cause) {
		super(cause);
		
	}

	public AddBodyException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AddBodyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
