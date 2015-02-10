package com.livebet.domain.operation;

public interface BusinessResponse {
	public boolean isResult();

	public void setResult(boolean result);

	public String getCause();

	public void setCause(String cause);
}
