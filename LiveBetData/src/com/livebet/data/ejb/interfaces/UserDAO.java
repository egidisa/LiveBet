package com.livebet.data.ejb.interfaces;

import javax.ejb.Remote;

@Remote
public interface UserDAO {
	boolean authenticate(String username, String password);

	boolean isBettor(String username);

	boolean isBookmaker(String username);
}
