package com.livebet.ejb.interfaces;

import javax.ejb.Remote;

import com.livebet.domain.operation.ChangeQuotesRequest;
import com.livebet.domain.operation.ChangeQuotesResponse;

@Remote
public interface Bookmaker {
	ChangeQuotesResponse changeQuotes(ChangeQuotesRequest cqr);
}
