package com.livebet.domain.operation;

import com.livebet.domain.Event;
import com.livebet.domain.Quote;

@Deprecated
public class ChangeQuotesRequest implements GenericRequest {

	public ChangeQuotesRequest(Event match, Quote quote) {
		super();
		this.match = match;
		this.quote = quote;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4088323548954544586L;

	Event match;
	Quote quote;

	public Event getMatch() {
		return match;
	}

	public void setMatch(Event match) {
		this.match = match;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

}
