/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livebet.domain.operation;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author p3
 */
public class UpdateQuoteRequest implements BusinessRequest {
	private Integer IDQuote;
	private AtomicInteger newNumericQuote;

	public UpdateQuoteRequest(Integer iDQuote, AtomicInteger newNumericQuote) {
		super();
		IDQuote = iDQuote;
		this.newNumericQuote = newNumericQuote;
	}

	public Integer getIDQuote() {
		return IDQuote;
	}

	public void setIDQuote(Integer IDQuote) {
		this.IDQuote = IDQuote;
	}

	public AtomicInteger getNewNumericQuote() {
		return newNumericQuote;
	}

	public void setNewNumericQuote(AtomicInteger newNumericQuote) {
		this.newNumericQuote = newNumericQuote;
	}

	@Override
	public String toString() {
		return "UpdateQuoteRequest{" + "IDQuote=" + IDQuote
				+ ", newNumericQuote=" + newNumericQuote + '}';
	}

}
