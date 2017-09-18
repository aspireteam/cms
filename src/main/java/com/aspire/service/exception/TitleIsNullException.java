package com.aspire.service.exception;

public class TitleIsNullException extends RuntimeException {

	private static final long serialVersionUID = 2383004581011384505L;

	public TitleIsNullException() {
		
	}

	public TitleIsNullException(String message) {
		super(message);
		
	}

	public TitleIsNullException(Throwable cause) {
		super(cause);
		
	}

	public TitleIsNullException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public TitleIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
