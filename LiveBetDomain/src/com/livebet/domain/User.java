package com.livebet.domain;

public class User {

	// info to distinguish between different users' types; used during login to
	// use the right user

	public static enum USER_TYPE {
		ANONYMOUS, BOOKMAKER, BETTOR
	}

	Integer id;
	String name;
	String surname;
	String username;
	String password;

	/**
	 * Default constructor.
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	// NEVER show a password anywhere.
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", username="
				+ username + "]";
	}

	public User(String name, String surname, String username, String password) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
