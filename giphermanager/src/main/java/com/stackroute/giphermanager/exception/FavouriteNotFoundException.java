package com.stackroute.giphermanager.exception;

@SuppressWarnings("serial")
public class FavouriteNotFoundException extends Exception {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public FavouriteNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "FavouriteNotFoundException [message=" + message + "]";
	}

}
