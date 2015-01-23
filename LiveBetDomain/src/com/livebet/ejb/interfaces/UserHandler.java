package com.livebet.ejb.interfaces;

import javax.ejb.Remote;

import com.livebet.domain.operation.LoginRequest;
import com.livebet.domain.operation.LoginResponse;
import com.livebet.domain.operation.LogoutRequest;
import com.livebet.domain.operation.LogoutResponse;
import com.livebet.domain.operation.RegisterRequest;
import com.livebet.domain.operation.RegisterResponse;

@Remote
public interface UserHandler {
	LoginResponse login(LoginRequest lr);
	LogoutResponse logout(LogoutRequest lr);
	RegisterResponse register(RegisterRequest rr);
}
