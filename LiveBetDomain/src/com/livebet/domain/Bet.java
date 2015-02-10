package com.livebet.domain;


public class Bet {
	User user;
	// Match match; already present inside Quotes
	Integer money;
	Quote quote;

	public Bet(User user, Integer money, Quote quote) {
		super();
		this.user = user;
		this.money = money;
		this.quote = quote;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

}
