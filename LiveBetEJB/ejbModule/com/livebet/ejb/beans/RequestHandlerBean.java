package com.livebet.ejb.beans;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.livebet.domain.operation.BusinessRequest;
import com.livebet.ejb.interfaces.RequestHandler;

/**
 * 
 * @author p3 Edited: Alessio
 */
@Singleton
public class RequestHandlerBean implements RequestHandler {
	private ArrayBlockingQueue<BusinessRequest> requestsQueue;
	private final Integer MAX_REQUESTS = 100000;

	public Integer getMAX_REQUESTS() {
		return MAX_REQUESTS;
	}

	@PostConstruct
	public void init() {
		requestsQueue = new ArrayBlockingQueue<BusinessRequest>(MAX_REQUESTS,
				true);
		System.out.println("PostConstructoo");
	}

	public void putReq(BusinessRequest request) {
		try {
			requestsQueue.put(request);
			// I use put instead of Add because if the queue is full, a new
			// request wait

		} catch (InterruptedException ex) {
			System.out.println("Error request");
		}
	}

	public BusinessRequest takeReq() {
		try {
			return requestsQueue.take();
		} catch (InterruptedException ex) {
			System.out.println("Error request");
			return null;
		}
	}

	public Integer getRequestNumber() {
		System.out.println("Queue requests: " + requestsQueue.toString()
				+ " size: " + requestsQueue.size());
		return requestsQueue.size();
	}

	public BusinessRequest getLastRequest() {
		try {
			return requestsQueue.take();
		} catch (InterruptedException ex) {
			Logger.getLogger(RequestHandlerBean.class.getName()).log(Level.SEVERE,
					null, ex);
			return null;
		}
	}

	public String getAllElements() {
		if (requestsQueue.isEmpty() | requestsQueue == null)
			return "There aren't requests in the queue";
		else
			return "There are " + requestsQueue.size()
					+ " requests in the queue\n " + "Requests list: "
					+ requestsQueue.toString();
	}

	public void printAllElement() {

	}
}
