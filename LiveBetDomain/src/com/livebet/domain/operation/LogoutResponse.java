package com.livebet.domain.operation;

public class LogoutResponse implements GenericResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2913650024855417458L;

	boolean result; // true = user logged in; false = unknown user
	String redirectURL;
	String message; // a message related to the result

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
