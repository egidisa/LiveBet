package com.livebet.domain;

import com.livebet.ejb.interfaces.Bettor;

public class Bet {
	Bettor bettor;
	// Match match; already present inside Quotes
	float money;
	Quotes quotes;

	public Bettor getBettor() {
		return bettor;
	}

	public void setBettor(Bettor bettor) {
		this.bettor = bettor;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Quotes getQuotes() {
		return quotes;
	}

	public void setQuotes(Quotes quotes) {
		this.quotes = quotes;
	}

}
