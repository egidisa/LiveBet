package com.livebet.ejb.interfaces;

import javax.ejb.Remote;

import com.livebet.domain.operation.BusinessRequest;

@Remote
public interface RequestHandler {
	public Integer getMAX_REQUESTS();

	public void putReq(BusinessRequest request);

	public BusinessRequest takeReq();

	public Integer getRequestNumber();

	public BusinessRequest getLastRequest();

	public String getAllElements();

	public void printAllElement();
}
