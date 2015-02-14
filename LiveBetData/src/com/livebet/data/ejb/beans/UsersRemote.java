package com.livebet.data.ejb.beans;

import javax.ejb.Remote;

@Remote
public interface UsersRemote {
	boolean usernameExists(String username);
}
