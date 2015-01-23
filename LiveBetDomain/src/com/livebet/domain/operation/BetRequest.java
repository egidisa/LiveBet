package com.livebet.domain.operation;

import com.livebet.domain.Bet;
import com.livebet.domain.Match;

public class BetRequest implements GenericRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 681662227745800218L;

	Match match;
	Bet bet;

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Bet getBet() {
		return bet;
	}

	public void setBet(Bet bet) {
		this.bet = bet;
	}

}
