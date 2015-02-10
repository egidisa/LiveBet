package com.livebet.domain.operation;

import com.livebet.domain.Bet;
import com.livebet.domain.Event;

@Deprecated
public class BetRequest implements GenericRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 681662227745800218L;

	Event event;
	Bet bet;

	public BetRequest(Event event, Bet bet) {
		super();
		this.event = event;
		this.bet = bet;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Bet getBet() {
		return bet;
	}

	public void setBet(Bet bet) {
		this.bet = bet;
	}

}
