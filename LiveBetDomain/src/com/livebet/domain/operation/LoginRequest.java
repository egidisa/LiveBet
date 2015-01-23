package com.livebet.domain.operation;

import java.util.Date;

import com.livebet.domain.User;

public class LoginRequest implements GenericRequest {

	@Override
	public String toString() {
		return "LoginRequest [user=" + user + ", loginDate=" + loginDate + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7236908702801857104L;

	User user;
	Date loginDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
}
