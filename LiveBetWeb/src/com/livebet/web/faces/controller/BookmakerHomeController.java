package com.livebet.web.faces.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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
import com.livebet.domain.operation.UpdateQuoteRequest;
import com.livebet.domain.operation.UpdateQuoteResponse;
import com.livebet.ejb.interfaces.EventHandler;
import com.livebet.web.ejbclients.BookmakerClient;

@Named("bookmakerHomeController")
@RequestScoped
public class BookmakerHomeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7392844434251018841L;

	private final static Logger log = Logger
			.getLogger(BookmakerHomeController.class.getCanonicalName());

	@Inject
	BookmakerClient bookmakerClient;

	@EJB
	EventHandler eventHandler;

	List<Event> eventList;
	private String message;

	private Integer newQuoteValue;

	@PostConstruct
	public void init() {
		log.setLevel(Level.ALL);

		log.info("ENTERING --> " + getClass().getCanonicalName() + ".init");

		log.info("USER = " + bookmakerClient.getBookmakerBean().getUsername());

		if (bookmakerClient.getBookmakerBean().getUsername() == null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.dispatch("/view/login.xhtml");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		eventList = eventHandler.getEvents();

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

	public String submitQuote() {
		Quote q = getQuoteFromFacesContext();
		Event e = getEventFromFacesContext();

		log.info("Quote = " + q.getId() + " " + q.getOutcome());
		log.info("Event = " + e.getId() + " " + e.getName());

		for (Quote q1 : e.getQuotes()) {
			log.info("QuoteID = " + q1.getId() + " Value = " + q1.getValue());
		}
		log.info("QuoteValue = " + newQuoteValue);
		UpdateQuoteRequest uqr = new UpdateQuoteRequest(q.getId(),
				new AtomicInteger(newQuoteValue));
		UpdateQuoteResponse changeQuotesResponse = bookmakerClient
				.getBookmakerBean().updateQuote(uqr);

		q.setValue(new AtomicInteger(newQuoteValue));

		if (!changeQuotesResponse.isResult())
			message = "QuoteUpdate rejected: "
					+ changeQuotesResponse.getCause();
		else
			message = "Quote Update received!";
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

	public BookmakerClient getBookmakerClient() {
		return bookmakerClient;
	}

	public Integer getNewQuoteValue() {
		return newQuoteValue;
	}

	public void setNewQuoteValue(Integer newQuoteValue) {
		this.newQuoteValue = newQuoteValue;
	}

}
