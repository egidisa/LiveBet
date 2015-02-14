/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livebet.ejb.beans;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.livebet.data.ejb.interfaces.RequestDAO;
import com.livebet.domain.Event;
import com.livebet.ejb.interfaces.EventHandler;

/**
 * 
 * @author p3
 */
@Stateless
public class EventsHandlerBean implements EventHandler {

	@EJB
	RequestDAO requestDAO;
	
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
		
		return requestDAO.getEvents();// SELECT ALL EVENTS FROM JAVA DB
	}
}
