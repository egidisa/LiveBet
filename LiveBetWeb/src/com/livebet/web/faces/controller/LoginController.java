package com.livebet.web.faces.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.livebet.domain.User;
import com.livebet.domain.operation.LoginRequest;
import com.livebet.domain.operation.LoginResponse;
import com.livebet.ejb.interfaces.UserHandler;
import com.livebet.web.ejbclients.BettorClient;

/*
 *  Specifies that a bean is request scoped.

 The request scope is active:

 during the service() method of any servlet in the web application, during the doFilter()
 method of any servlet filter and when the container calls any ServletRequestListener or
 AsyncListener, during any Java EE web service invocation, during any remote method
 invocation of any EJB, during any asynchronous method invocation of any EJB,
 during any call to an EJB timeout method and during message delivery to any EJB
 message-driven bean, and during any message delivery to a MessageListener for a
 JMS topic or queue obtained from the Java EE component environment.

 The request context is destroyed:

 at the end of the servlet request, after the service() method, all doFilter() methods,
 and all requestDestroyed() and onComplete() notifications return, after the web service
 invocation completes, after the EJB remote method invocation, asynchronous method
 invocation, timeout or message delivery completes, or after the message delivery to
 the MessageListener completes.

 * */

@Named("loginController")
@RequestScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5391161311944191726L;

	private final static Logger log = Logger.getLogger(LoginController.class
			.getCanonicalName());

	private static final String CURRENT_VIEW = null;
	private String NEXT_VIEW = null;
	private static final String BETTOR_HOME_PAGE = "BETTOR_HOME";
	private static final String BOOKMAKER_HOME_PAGE = "BOOKMAKER_HOME";

	// TODO check wheter the bettorClient, once injected in another class, still
	// holds
	// the reference to right bettorBean.
	@Inject
	BettorClient bettorClient;

	// TODO implement BookmakerClient class
	// @Inject
	// BookmakerClient bookmakerClient;

	@EJB
	UserHandler userHandlerBean;

	private String message;

	private String username;

	private String password;

	@PostConstruct
	public void init() {
		log.setLevel(Level.ALL);

		log.info("ENTERING --> " + getClass().getCanonicalName() + ".init");
		// initialization code
		log.info("LEAVING <-- " + getClass().getCanonicalName() + ".init");
	}

	public String submit() {
		log.info("ENTERING --> " + getClass().getCanonicalName() + ".submit");

		LoginRequest lr = new LoginRequest();

		log.info("LoginController:" + username + password);

		User user = new User("", "", username, password);

		lr.setUser(user);
		lr.setLoginDate(new Date(System.currentTimeMillis()));

		LoginResponse lresp = userHandlerBean.login(lr);
		if (lresp.isResult()) {
			// here is where the appropriate EJB has to be chosen, so that
			// only the right one will be left in memory
			log.info("USER_TYPE = " + lresp.getUserType());
			switch (lresp.getUserType()) {
			case ANONYMOUS:
				NEXT_VIEW = CURRENT_VIEW;
				break;
			case BETTOR:
				// setting data to BettorBean
				// what if we do bettorBean.setUser(user)? Check which methods
				// of the EJB work,
				// if just the ones of the interface or not.
				bettorClient.getBettorBean().setUsername(username);
				bettorClient.getBettorBean().setPassword(password);
				// TODO insert a bookmakerBean.removeBean() method that removes
				// the bean and call it here.
				NEXT_VIEW = BETTOR_HOME_PAGE;
				break;
			case BOOKMAKER:
				// TODO setting data to BookmakerBean
				// TODO insert a bettorBean.removeBean() method that removes
				// the bean and call it here.
				NEXT_VIEW = BOOKMAKER_HOME_PAGE;
			}
		}

		message = lresp.getMessage();

		log.info("LEAVING <-- " + getClass().getCanonicalName() + ".submit");
		return NEXT_VIEW;
	}

	public LoginController() {
	}

	public String getMessage() {
		return message;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
