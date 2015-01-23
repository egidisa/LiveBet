package com.livebet.domain.operation;

import com.livebet.domain.Match;
import com.livebet.domain.Quotes;
import com.livebet.ejb.interfaces.Bookmaker;

public class ChangeQuotesRequest implements GenericRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4088323548954544586L;

	Bookmaker bookmaker;
	Match match;
	Quotes quotes;

	public Bookmaker getBookmaker() {
		return bookmaker;
	}

	public void setBookmaker(Bookmaker bm) {
		this.bookmaker = bm;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match m) {
		this.match = m;
	}

	public Quotes getQuotes() {
		return quotes;
	}

	public void setQuotes(Quotes q) {
		this.quotes = q;
	}
}
