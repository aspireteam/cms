package com.aspire.service.exception;

public class RemoveTitleException extends RuntimeException {

	private static final long serialVersionUID = 2383004581011384505L;

	public RemoveTitleException() {
		
	}

	public RemoveTitleException(String message) {
		super(message);
		
	}

	public RemoveTitleException(Throwable cause) {
		super(cause);
		
	}

	public RemoveTitleException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public RemoveTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
