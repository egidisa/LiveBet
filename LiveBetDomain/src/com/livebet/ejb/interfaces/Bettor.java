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

	public String getName();

	public void setName(String name);

	public String getSurname();

	public void setSurname(String surname);

	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);

	public Integer getMoney();

	public void setMoney(Integer money);
}
