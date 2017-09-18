package com.aspire.service.exception;

public class AddTitleException extends RuntimeException {

	private static final long serialVersionUID = 2383004581011384505L;

	public AddTitleException() {
		
	}

	public AddTitleException(String message) {
		super(message);
		
	}

	public AddTitleException(Throwable cause) {
		super(cause);
		
	}

	public AddTitleException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AddTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
