package com.livebet.web.faces.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.livebet.domain.Event;
import com.livebet.domain.Quote;
import com.livebet.domain.User;
import com.livebet.domain.operation.RegisterBetRequest;
import com.livebet.domain.operation.RegisterBetResponse;
import com.livebet.ejb.interfaces.EventHandler;
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

	@EJB
	EventHandler eventHandler;

	List<Event> eventList;

	private String message;

	private Integer money;

	@PostConstruct
	public void init() {
		log.setLevel(Level.ALL);

		log.info("ENTERING --> " + getClass().getCanonicalName() + ".init");

		log.info("USER = " + bettorClient.getBettorBean().getUsername());

		if (bettorClient.getBettorBean().getUsername().compareTo("") == 0) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.dispatch("/view/login.xhtml");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		eventList = eventHandler.getEvents();
		if(bettorClient.getEventList() == null)
			bettorClient.setEventList(eventList);
		
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

		log.info("Quote = " + q.toString());
		log.info("Event = " + e.getId() + " " + e.getName());
		log.info("Money = " + money);
		
		Quote clientQuote = getClientQuote(e.getId(), q.getId());
		
		log.info("CLIENTQuote = " + clientQuote.toString());
		
		RegisterBetRequest br = new RegisterBetRequest(clientQuote, u.getId(),
				money);
		RegisterBetResponse betResponse = bettorClient.getBettorBean().bet(br);

		if (!betResponse.isResult())
			message = "Bet rejected: " + betResponse.getCause();
		else
			message = "Bet received!";
		
		eventList = eventHandler.getEvents();
		bettorClient.setEventList(eventList);
		
		return "";
	}

	private Quote getClientQuote(Integer eid, Integer qid) {

		for(Event e : bettorClient.getEventList()){
			if(e.getId().compareTo(eid) == 0){
				for(Quote q : e.getQuotes()){
					if(q.getId().compareTo(qid) == 0)
						return q;
				}
			}
		}
		
		return null;
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
