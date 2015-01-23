package com.livebet.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class Quotes {
	public enum ResultsToQuotes {
		TEAM1_WIN(0),
		// TEAM1_LOSES(0.0f),
		TEAM2_WIN(0);
		// TEAM2_LOSES(0.0f);

		private AtomicInteger quote;

		ResultsToQuotes(Integer q) {
			quote = new AtomicInteger(q);
		}

		public Integer getQuote() {
			return quote.get();
		}

		public void setQuote(Integer q) {
			quote = new AtomicInteger(q);
		}
	}

	Match match;

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}
