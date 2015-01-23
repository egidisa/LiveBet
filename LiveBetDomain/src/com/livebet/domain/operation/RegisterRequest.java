package com.livebet.domain.operation;

import java.util.Date;

import com.livebet.domain.User;

public class RegisterRequest implements GenericRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8388161499339985607L;

	User user;
	String secretQuestion;
	String secretAnswer;
	Date registerDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public Date getregisterDate() {
		return registerDate;
	}

	public void setregisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
}
