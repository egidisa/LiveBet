package com.livebet.domain.operation;

import com.livebet.domain.User;

public class LoginResponse implements GenericResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5414033680970702944L;
	
	boolean result; // true = user logged in; false = unknown user
	User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	String message; // a message related to the result

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
