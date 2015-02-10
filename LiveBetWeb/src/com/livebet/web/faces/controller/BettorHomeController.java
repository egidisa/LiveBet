package com.livebet.web.faces.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.livebet.domain.Event;
import com.livebet.domain.Quote;
import com.livebet.domain.User;
import com.livebet.domain.operation.RegisterBetRequest;
import com.livebet.domain.operation.RegisterBetResponse;
import com.livebet.web.ejbclients.BettorClient;

@Named("bettorHomeController")
@RequestScoped
public class BettorHomeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -825203143619925031L;

	private final static Logger log = Logger
			.getLogger(BettorHomeController.class.getCanonicalName());

	@Inject
	BettorClient bettorClient;

	List<Event> eventList;
	private String message;

	private Integer money;

	@PostConstruct
	public void init() {
		log.setLevel(Level.ALL);

		log.info("ENTERING --> " + getClass().getCanonicalName() + ".init");

		log.info("USER = " + bettorClient.getBettorBean().getUsername());

		if (bettorClient.getBettorBean().getUsername() == null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.dispatch("/view/login.xhtml");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		bettorClient.getBettorBean().setMoney(10);

		eventList = new ArrayList<Event>();

		Event e = new Event();
		e.setId(1);
		e.setName("Juventus - Milan");
		e.setOutcome("");
		List<Quote> q = new ArrayList<Quote>();
		q.add(new Quote(new Integer(1), "1 - 0 Juventus", new AtomicInteger(2),
				new AtomicInteger(0), new Date(System.currentTimeMillis())));
		q.add(new Quote(new Integer(2), "0 - 1 Milan", new AtomicInteger(2),
				new AtomicInteger(0), new Date(System.currentTimeMillis())));
		q.add(new Quote(new Integer(3), "0 - 0", new AtomicInteger(1),
				new AtomicInteger(0), new Date(System.currentTimeMillis())));
		e.setQuotes(q);

		eventList.add(e);

		e = new Event();
		e.setId(2);
		e.setName("Roma - Napoli");
		e.setOutcome("");

		q = new ArrayList<Quote>();
		q.add(new Quote(new Integer(4), "1 - 0 Roma", new AtomicInteger(2),
				new AtomicInteger(0), new Date(System.currentTimeMillis())));
		q.add(new Quote(new Integer(5), "0 - 1 Napoli", new AtomicInteger(3),
				new AtomicInteger(0), new Date(System.currentTimeMillis())));
		q.add(new Quote(new Integer(6), "0 - 0", new AtomicInteger(1),
				new AtomicInteger(0), new Date(System.currentTimeMillis())));
		e.setQuotes(q);

		eventList.add(e);

		e = new Event();
		e.setId(3);
		e.setName("Palermo - Sampdoria");
		e.setOutcome("");

		q = new ArrayList<Quote>();
		q.add(new Quote(new Integer(7), "1 - 0 Palermo", new AtomicInteger(1),
				new AtomicInteger(0), new Date(System.currentTimeMillis())));
		q.add(new Quote(new Integer(8), "0 - 1 Sampdoria",
				new AtomicInteger(3), new AtomicInteger(0), new Date(System
						.currentTimeMillis())));
		q.add(new Quote(new Integer(9), "0 - 0", new AtomicInteger(2),
				new AtomicInteger(0), new Date(System.currentTimeMillis())));
		e.setQuotes(q);

		eventList.add(e);

		log.info("LEAVING <-- " + getClass().getCanonicalName() + ".init");
	}

	private Quote getQuoteFromFacesContext() {
		Quote q;
		q = (Quote) FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap().get("q");

		return (q);
	}

	private Event getEventFromFacesContext() {
		Event e;
		e = (Event) FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap().get("e");

		return (e);
	}

	public String submitBet() {
		Quote q = getQuoteFromFacesContext();
		Event e = getEventFromFacesContext();
		User u = bettorClient.getBettorBean().getUser();

		log.info("Quote = " + q.getId() + " " + q.getOutcome());
		log.info("Event = " + e.getId() + " " + e.getName());
		log.info("Money = " + money);
		RegisterBetRequest br = new RegisterBetRequest(q.getId(),
				u.getId(), money);
		RegisterBetResponse betResponse = bettorClient.getBettorBean().bet(br);

		if (!betResponse.isResult())
			message = "Bet rejected: " + betResponse.getCause();
		else
			message = "Bet received!";
		return "";
	}

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BettorClient getBettorClient() {
		return bettorClient;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}
