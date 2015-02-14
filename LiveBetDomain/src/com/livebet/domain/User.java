package com.livebet.domain;

public class User {

	// info to distinguish between different users' types; used during login to
	// use the right user

	public static enum USER_TYPE {
		ANONYMOUS, BOOKMAKER, BETTOR
	}

	Integer id;
	String username;
	String password;
	String userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}

	public User(Integer id, String username, String password, String userType) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
