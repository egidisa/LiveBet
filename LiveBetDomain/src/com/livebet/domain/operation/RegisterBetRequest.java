/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livebet.domain.operation;

/**
 * 
 * @author p3 Edit: Alessio
 */
public class RegisterBetRequest implements BusinessRequest {
	private Integer IDQuote;
	private Integer IDUsername;
	private Integer money;

	public RegisterBetRequest(Integer iDQuote, Integer iDUsername, Integer money) {
		super();
		IDQuote = iDQuote;
		IDUsername = iDUsername;
		this.money = money;
	}

	public Integer getIDQuote() {
		return IDQuote;
	}

	public void setIDQuote(Integer IDQuote) {
		this.IDQuote = IDQuote;
	}

	public Integer getIDUsername() {
		return IDUsername;
	}

	public void setIDUsername(Integer IDUsername) {
		this.IDUsername = IDUsername;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "RegisterBetRequest{" + "IDQuote=" + IDQuote + ", IDUsername="
				+ IDUsername + ", money=" + money + '}';
	}

}
