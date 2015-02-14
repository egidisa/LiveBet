package com.livebet.ejb.interfaces;

import javax.ejb.Remote;

import com.livebet.domain.User;
import com.livebet.domain.operation.RegisterBetRequest;
import com.livebet.domain.operation.RegisterBetResponse;

@Remote
public interface Bettor {
	RegisterBetResponse bet(RegisterBetRequest br);

	public void removeBean();

	public User getUser();

	public void setUser(User user);

	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);

	public Integer getMoney();

	public void setMoney(Integer money);
}
