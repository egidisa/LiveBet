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

	public void setUser(User user);

	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);
}
