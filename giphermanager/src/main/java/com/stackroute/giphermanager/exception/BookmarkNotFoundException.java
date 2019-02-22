package com.stackroute.giphermanager.exception;

@SuppressWarnings("serial")
public class BookmarkNotFoundException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GifNotFoundException [message=" + message + "]";
	}

	public BookmarkNotFoundException(String message) {
		super();
		this.message = message;
	}

}
