package com.aspire.service.exception;

/**
 * 没有发现此用户异常
 */
public class UsernameNotFindException extends RuntimeException {

	private static final long serialVersionUID = -6210806296506955303L;

	public UsernameNotFindException() {

	}

	public UsernameNotFindException(String message) {
		super(message);
		
	}

	public UsernameNotFindException(Throwable cause) {
		super(cause);
		
	}

	public UsernameNotFindException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UsernameNotFindException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
