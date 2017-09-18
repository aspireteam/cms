package com.aspire.service.exception;

public class UpdateBodyException extends RuntimeException {

	private static final long serialVersionUID = 2383004581011384505L;

	public UpdateBodyException() {
		
	}

	public UpdateBodyException(String message) {
		super(message);
		
	}

	public UpdateBodyException(Throwable cause) {
		super(cause);
		
	}

	public UpdateBodyException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UpdateBodyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
