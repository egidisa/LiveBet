package com.livebet.domain.operation;

import com.livebet.domain.Quotes;

public class ChangeQuotesResponse implements GenericResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3660256240475168010L;

	Quotes newQuotes;

	public Quotes getNewQuotes() {
		return newQuotes;
	}

	public void setNewQuotes(Quotes newQuotes) {
		this.newQuotes = newQuotes;
	}

}
