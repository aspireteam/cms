package com.aspire.service.exception;

/**
 * 密码异常
 */
public class PasswordException extends RuntimeException {

	private static final long serialVersionUID = -3784885489718172202L;

	public PasswordException() {

	}

	public PasswordException(String message) {
		super(message);

	}

	public PasswordException(Throwable cause) {
		super(cause);
		
	}

	public PasswordException(String message, Throwable cause) {
		super(message, cause);

	}

	public PasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
