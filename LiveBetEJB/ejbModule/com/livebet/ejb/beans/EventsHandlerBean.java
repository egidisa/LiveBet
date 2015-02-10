/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livebet.ejb.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.Stateless;

import com.livebet.domain.Event;
import com.livebet.domain.Quote;
import com.livebet.ejb.interfaces.EventHandler;

/**
 * 
 * @author p3
 */
@Stateless
public class EventsHandlerBean implements EventHandler {
	// private ArrayList<Event> events;

	// public EventsHandlerBean() {
	// }

	public void registerEvent(String name) {
		// Event e = new Event(name);
		// events.add(e);
		// INSERT EVENT INTO JAVA DB
	}

	// NON NECESSARIO
	public void updateEvent(Integer ID, String name) {
		// MODIFY NAME EVENT WHERE ID IS...
	}

	// NON NECESSARIO
	public void deleteEvent(Integer ID) { // DELETE FROM JAVADB WHERE ID IS...
	}

	// NON NECESSARIO
	public void deleteQuote(Integer IDQuote) { // DELETE QUOTE FROM JAVADB WHERE
												// ID EVENT IS... AND OUTCOME
												// IS...
	}

	public void addQuotes(Integer IDEvent, String outcome,
			AtomicInteger version, AtomicInteger NumericQuote, Date timestamp) {

	}

	public List<Event> getEvents() {
		// TODO chiamare DB
		ArrayList<Event> eventList = new ArrayList<Event>();

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

		return eventList;// SELECT ALL EVENTS FROM JAVA DB
	}
}
