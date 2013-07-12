package com.ahmetkizilay.yatlib4j.exceptions;

public class TwitterIOException extends Exception {
	private int statusCode;
	public TwitterIOException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;	
	}
	
	public int getStatusCode() {
		return this.statusCode;
	}
}
