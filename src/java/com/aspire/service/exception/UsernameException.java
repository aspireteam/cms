package com.aspire.service.exception;

/**
 * 用户异常
 */
public class UsernameException extends RuntimeException {

	private static final long serialVersionUID = 5449542187147553866L;

	public UsernameException() {

	}

	public UsernameException(String message) {
		super(message);

	}

	public UsernameException(Throwable cause) {
		super(cause);
		
	}

	public UsernameException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
