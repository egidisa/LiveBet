package com.livebet.domain.operation;

@Deprecated
public class BetResponse implements GenericResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 618544181141119244L;

	/*
	 * result = true -> OK result = false -> KO
	 */
	boolean result;
	String cause;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

}
