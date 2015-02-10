package com.livebet.ejb.interfaces;

import javax.ejb.Remote;

import com.livebet.domain.operation.RegisterBetRequest;
import com.livebet.domain.operation.RegisterBetResponse;
import com.livebet.domain.operation.UpdateQuoteRequest;
import com.livebet.domain.operation.UpdateQuoteResponse;

@Remote
public interface QuotesHandler {
	public UpdateQuoteResponse updateQuote(UpdateQuoteRequest uqr);

	public RegisterBetResponse registerBet(RegisterBetRequest rbr);
}
