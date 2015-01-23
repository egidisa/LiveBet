package com.livebet.domain.operation;

public class RegisterResponse implements GenericResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3420559562716026300L;

	boolean result; // true = user logged in; false = unknown user
	String activationCode;
	String message; // a message related to the result

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
