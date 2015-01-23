package com.livebet.ejb.beans;

import javax.ejb.Stateful;

import com.livebet.domain.operation.ChangeQuotesRequest;
import com.livebet.domain.operation.ChangeQuotesResponse;
import com.livebet.ejb.interfaces.Bookmaker;

/**
 * Session Bean implementation class BookmakerBean
 */
@Stateful(mappedName = "BookmakerBean")
public class BookmakerBean implements Bookmaker {

	String name;
	String surname;
	String nickname;
	String password;

	/**
	 * Default constructor.
	 */
	public BookmakerBean() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @see Bookmaker#changeQuotes(ChangeQuotesRequest)
	 */
	public ChangeQuotesResponse changeQuotes(ChangeQuotesRequest cqr) {
		// TODO Auto-generated method stub
		return null;
	}

}
