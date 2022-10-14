package com.neurogine.assesment.exception;

public class InputValidationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	public InputValidationException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
