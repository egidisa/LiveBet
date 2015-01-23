package com.livebet.ejb.interfaces;

import javax.ejb.Remote;

import com.livebet.domain.User;
import com.livebet.domain.operation.ChangeQuotesRequest;
import com.livebet.domain.operation.ChangeQuotesResponse;

@Remote
public interface Bookmaker {
	ChangeQuotesResponse changeQuotes(ChangeQuotesRequest cqr);

	public void removeBean();

	public User getUser();

	public String getName();

	public void setName(String name);

	public String getSurname();

	public void setSurname(String surname);

	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);
}
