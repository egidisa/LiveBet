package com.livebet.data.ejb.beans;
import java.util.*;

import javax.ejb.Stateless;

import com.livebet.data.ejb.interfaces.UserDAO;
import com.livebet.domain.User;

@Stateless(mappedName = "UserDAOBean")
public class UserDAOBean implements UserDAO {

	// mock to simulate user "Pippo"
//	private final static String NAME = "Pippo";
//	private final static String SURNAME = "Pippo";
	private final static String USERNAME = "Pippo";
	private final static String PASSWORD = "Pippo";
	private final static User.USER_TYPE USER_TYPE = User.USER_TYPE.BOOKMAKER;

	/**
	 * Default constructor.
	 */
	public UserDAOBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		if (username.compareTo(USERNAME) == 0
				&& password.compareTo(PASSWORD) == 0)
			return true;
		return false;
	}

	@Override
	public boolean isBettor(String username) {
		// db search for the given username...
		return User.USER_TYPE.BETTOR == USER_TYPE;
	}

	@Override
	public boolean isBookmaker(String username) {
		// db search for the given username...
		return User.USER_TYPE.BOOKMAKER == USER_TYPE;
	}

}
