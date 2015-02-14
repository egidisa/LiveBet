package com.livebet.ejb.beans;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.livebet.data.ejb.interfaces.RequestDAO;
import com.livebet.data.ejb.interfaces.UserDAO;
import com.livebet.domain.User;
import com.livebet.domain.operation.LoginRequest;
import com.livebet.domain.operation.LoginResponse;
import com.livebet.domain.operation.LogoutRequest;
import com.livebet.domain.operation.LogoutResponse;
import com.livebet.domain.operation.RegisterRequest;
import com.livebet.domain.operation.RegisterResponse;
import com.livebet.ejb.interfaces.UserHandler;

/**
 * Session Bean implementation class UserHandlerBean
 */
@Stateless(mappedName = "UserHandlerBean")
public class UserHandlerBean implements UserHandler {

	private final static Logger log = Logger.getLogger(UserHandlerBean.class
			.getName());

	private final static String MSG_LOGIN_OK = "Login effettuato con successo!";
	private final static String MSG_LOGIN_KO = "Login fallito. Riprovare.";

	@EJB
	UserDAO userDAOBean;

	@EJB
	RequestDAO requestBean;

	/**
	 * Default constructor.
	 */
	public UserHandlerBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see UserHandler#logout(LogoutRequest)
	 */
	public LogoutResponse logout(LogoutRequest lr) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see UserHandler#login(LoginRequest)
	 */
	public LoginResponse login(LoginRequest lr) {
		log.setLevel(Level.ALL);
		log.info("ENTERING --> " + getClass().getCanonicalName() + ".login("
				+ lr.toString() + ")");

		String username = lr.getUser().getUsername();
		String password = lr.getUser().getPassword();

		LoginResponse lresp = new LoginResponse();
		lresp.setUser(null);

		boolean authenticationResult = requestBean.authenticate(username,
				password);
		lresp.setResult(authenticationResult);
		if (authenticationResult) {
			lresp.setMessage(MSG_LOGIN_OK);
			lresp.setUser(requestBean.getUser(username));
			log.info("USER " + lresp.getUser());
		} else
			lresp.setMessage(MSG_LOGIN_KO);

		log.info("LEAVING <-- " + getClass().getCanonicalName() + ".login");
		return lresp;
	}

	/**
	 * @see UserHandler#register(RegisterRequest)
	 */
	public RegisterResponse register(RegisterRequest rr) {
		// TODO Auto-generated method stub
		return null;
	}
}
