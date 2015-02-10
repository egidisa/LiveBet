package com.livebet.ejb.beans;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import com.livebet.domain.User;
import com.livebet.domain.operation.RegisterBetRequest;
import com.livebet.domain.operation.RegisterBetResponse;
import com.livebet.ejb.interfaces.Bettor;
import com.livebet.ejb.interfaces.QuotesHandler;

/*
 * As its name suggests, a session bean is similar to an interactive session. A session bean
 is not shared; it can have only one client, in the same way that an interactive session
 can have only one user. When the client terminates, its session bean appears to
 terminate and is no longer associated with the client.
 The state is retained for the duration of the client/bean session. If the client removes
 the bean, the session ends and the state disappears. This transient nature of the state is
 not a problem, however, because when the conversation between the client and the
 bean ends, there is no need to retain the state.
 * */

/*
 * To indicate a system-level problem, such as the inability to connect to a
 * database, a business method should throw a javax.ejb.EJBException. The
 * container will not wrap application exceptions, such as BookException.
 * Because EJBException is a subclass of RuntimeException, you do not need
 * to include it in the throws clause of the business method.
 */

/**
 * Session Bean implementation class BettorBean
 */
@Stateful(mappedName = "BettorBean")
public class BettorBean implements Bettor {

	private final static Logger log = Logger.getLogger(BettorBean.class
			.getCanonicalName());

	User user;
	Integer money;

	@EJB
	QuotesHandler quotesHandler;

	/**
	 * Default constructor.
	 */
	public BettorBean() {
		// TODO Auto-generated constructor stub
		money = 0;
	}

	@PostConstruct
	// initialization method
	private void init() {
		log.info("ENTERING --> " + getClass().getCanonicalName() + ".init");

		user = new User();

		log.info("LEAVING <-- " + getClass().getCanonicalName() + ".init");
	}

	/**
	 * @see Bettor#bet(RegisterBetRequest)
	 */
	public RegisterBetResponse bet(RegisterBetRequest br) {
		// TODO Auto-generated method stub
		RegisterBetResponse bResp = quotesHandler.registerBet(br);
		return bResp;
	}

	/* This method is called whenever the EJB has to be removed */
	@Remove
	@Override
	public void removeBean() {
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

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}
