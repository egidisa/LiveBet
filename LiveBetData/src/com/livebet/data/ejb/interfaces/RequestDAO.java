package com.livebet.data.ejb.interfaces;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RequestDAO {
	boolean userExists(String username);

	boolean authenticate(String username, String password);

	List<com.livebet.domain.Event> getEvents();

	boolean isBookmaker(int iduser);

	boolean isBettor(int iduser);

	boolean isBookmaker(String username);

	boolean isBettor(String username);

	boolean updateQuote(int idquote, int newvalue);

	com.livebet.domain.Quote getQuote(int idquote);

	Integer getCredit(int iduser);

	void setCredit(int iduser, int newCredit);

	boolean createBet(int idquote, int credit, int iduser);

	public com.livebet.domain.User getUser(String username);
}
