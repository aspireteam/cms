package com.aspire.service.exception;

public class BodyIsNullException extends RuntimeException {

	private static final long serialVersionUID = 2383004581011384505L;

	public BodyIsNullException() {
		
	}

	public BodyIsNullException(String message) {
		super(message);
		
	}

	public BodyIsNullException(Throwable cause) {
		super(cause);
		
	}

	public BodyIsNullException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BodyIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
