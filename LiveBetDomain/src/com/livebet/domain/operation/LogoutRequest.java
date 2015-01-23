package com.livebet.domain.operation;

import java.util.Date;

import com.livebet.domain.User;

public class LogoutRequest implements GenericRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6958190856420738730L;

	User user;
	Date logoutDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getlogoutDate() {
		return logoutDate;
	}

	public void setlogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

}
