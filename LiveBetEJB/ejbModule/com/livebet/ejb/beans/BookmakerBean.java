package com.livebet.ejb.beans;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import com.livebet.domain.User;
import com.livebet.domain.operation.ChangeQuotesRequest;
import com.livebet.domain.operation.ChangeQuotesResponse;
import com.livebet.ejb.interfaces.Bookmaker;

/**
 * Session Bean implementation class BookmakerBean
 */
@Stateful(mappedName = "BookmakerBean")
public class BookmakerBean implements Bookmaker {

	private final static Logger log = Logger.getLogger(BookmakerBean.class
			.getCanonicalName());

	User user;

	/**
	 * Default constructor.
	 */
	public BookmakerBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	// initialization method
	private void init() {
		log.info("ENTERING --> " + getClass().getCanonicalName() + ".init");

		user = new User();

		log.info("LEAVING <-- " + getClass().getCanonicalName() + ".init");
	}

	/* This method is called whenever the EJB has to be removed */
	@Remove
	@Override
	public void removeBean() {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public String getUsername() {
		return getUser().getUsername();
	}

	@Override
	public void setUsername(String username) {
		getUser().setUsername(username);
	}

	@Override
	public String getPassword() {
		return getUser().getPassword();
	}

	@Override
	public void setPassword(String password) {
		getUser().setPassword(password);
	}

	@Override
	public String getName() {
		return getUser().getName();
	}

	@Override
	public void setName(String name) {
		getUser().setName(name);
	}

	@Override
	public String getSurname() {
		return getUser().getSurname();
	}

	@Override
	public void setSurname(String surname) {
		getUser().setSurname(surname);
	}

	/**
	 * @see Bookmaker#changeQuotes(ChangeQuotesRequest)
	 */
	public ChangeQuotesResponse changeQuotes(ChangeQuotesRequest cqr) {
		// TODO Auto-generated method stub
		return null;
	}

}
