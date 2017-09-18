package com.aspire.service.exception;

public class UpdateTitleException extends RuntimeException {

	private static final long serialVersionUID = 2383004581011384505L;

	public UpdateTitleException() {
		
	}

	public UpdateTitleException(String message) {
		super(message);
		
	}

	public UpdateTitleException(Throwable cause) {
		super(cause);
		
	}

	public UpdateTitleException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UpdateTitleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
