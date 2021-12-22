package com.bl.onboarding.exception;

public class UserNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public UserNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public UserNotFoundException() {
	}

	public String getMessage() {
		return message;
	}

}
