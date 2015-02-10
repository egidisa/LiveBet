package com.livebet.domain;

import java.util.List;

public class Event {

	Integer id;
	String name;
	String outcome;
	List<Quote> quotes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", outcome=" + outcome
				+ ", quotes=" + quotes + "]";
	}
	
	
}
