package com.example.exceptionhandling;

public class ServiceException extends Exception {
	private int statusCode;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public ServiceException(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;

	}

}
