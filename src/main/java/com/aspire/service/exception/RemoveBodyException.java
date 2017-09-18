package com.aspire.service.exception;

public class RemoveBodyException extends RuntimeException {

	private static final long serialVersionUID = 2383004581011384505L;

	public RemoveBodyException() {
		
	}

	public RemoveBodyException(String message) {
		super(message);
		
	}

	public RemoveBodyException(Throwable cause) {
		super(cause);
		
	}

	public RemoveBodyException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public RemoveBodyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
