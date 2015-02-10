package com.livebet.domain.operation;

@Deprecated
public class ChangeQuotesResponse implements GenericResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3660256240475168010L;

	private boolean result;
	private String cause;

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
