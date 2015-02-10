package com.livebet.ejb.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.livebet.domain.Event;

@Remote
public interface EventHandler {
	public void registerEvent(String name);

	public List<Event> getEvents();
}
