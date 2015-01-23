package com.livebet.ejb.interfaces;

import javax.ejb.Remote;

import com.livebet.domain.User;
import com.livebet.domain.operation.BetRequest;
import com.livebet.domain.operation.BetResponse;

@Remote
public interface Bettor {
	BetResponse bet(BetRequest br);

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
