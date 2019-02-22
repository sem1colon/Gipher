package com.stackroute.giphermanager.exception;

@SuppressWarnings("serial")
public class BookmarkAlreadyExistsException extends Exception {
	private String message;

	@Override
	public String toString() {
		return "GifAlreadyBookmarkedException [message=" + message + "]";
	}

	public BookmarkAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
