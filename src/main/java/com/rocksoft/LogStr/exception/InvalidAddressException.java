package com.rocksoft.LogStr.exception;

public class InvalidAddressException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAddressException() {
		
	}
	public InvalidAddressException(String message) {
		super(message);
	}
	public InvalidAddressException(Throwable cause) {
		super(cause);
	}
	public InvalidAddressException(String message, Throwable cause) {
		super(message, cause);
	}

}
