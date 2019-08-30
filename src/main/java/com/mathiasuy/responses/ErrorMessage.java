package com.mathiasuy.responses;

public class ErrorMessage {

	private String message;

	public ErrorMessage() {
		super();
	}
	
	public ErrorMessage(String message) {
		super();
		this.message = message;
	}
	
	public String getError() {
		return "Error";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorMessage [message=" + message + "]";
	}

}
