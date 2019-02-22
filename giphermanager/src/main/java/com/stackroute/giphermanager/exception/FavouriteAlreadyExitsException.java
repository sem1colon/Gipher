package com.stackroute.giphermanager.exception;

@SuppressWarnings("serial")
public class FavouriteAlreadyExitsException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FavouriteAlreadyExitsException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "GifAlreadyFavouriteException [message=" + message + "]";
	}

}
