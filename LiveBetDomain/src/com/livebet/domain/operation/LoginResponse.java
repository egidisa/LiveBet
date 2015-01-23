package com.livebet.domain.operation;

import com.livebet.domain.User;

public class LoginResponse implements GenericResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5414033680970702944L;
	
	boolean result; // true = user logged in; false = unknown user
	User.USER_TYPE userType;
	String message; // a message related to the result

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public User.USER_TYPE getUserType() {
		return userType;
	}

	public void setUserType(User.USER_TYPE userType) {
		this.userType = userType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
