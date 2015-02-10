package com.livebet.ejb.interfaces;

import javax.ejb.Remote;

import com.livebet.domain.User;
import com.livebet.domain.operation.UpdateQuoteRequest;
import com.livebet.domain.operation.UpdateQuoteResponse;

@Remote
public interface Bookmaker {
	public UpdateQuoteResponse updateQuote(UpdateQuoteRequest uqr);

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
