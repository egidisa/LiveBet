/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livebet.domain.operation;

import com.livebet.domain.Quote;

/**
 * 
 * @author p3 Edit: Alessio
 */
public class RegisterBetRequest implements BusinessRequest {
	private Quote quote;
	private Integer IDUser;
	private Integer money;

	public RegisterBetRequest(Quote q, Integer iDUsername, Integer money) {
		super();
		quote = q;
		IDUser = iDUsername;
		this.money = money;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public Integer getIDUser() {
		return IDUser;
	}

	public void setIDUser(Integer IDUsername) {
		this.IDUser = IDUsername;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "RegisterBetRequest{" + "Quote=" + quote + ", IDUsername="
				+ IDUser + ", money=" + money + '}';
	}

}
