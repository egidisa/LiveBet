package com.livebet.data.ejb.beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Bet;
import model.Event;
import model.Quote;
import model.User;

import com.livebet.data.ejb.interfaces.RequestDAO;

/**
 * Session Bean implementation class Request
 */
@Stateless
public class RequestDAOBean implements RequestDAO {
	@PersistenceContext(name = "LiveBetData")
	private EntityManager em;

	private static final Logger logger = Logger.getLogger("order.ejb.Request");

	// Event
	public void createEvent(String eventName, String outcome) {
		try {
			Event event = new Event(eventName, outcome);
			logger.log(Level.INFO, "Created event {0}-{1}", new Object[] {
					eventName, outcome });
			em.persist(event);
			logger.log(Level.INFO, "Persisted event {0}-{1}", new Object[] {
					eventName, outcome });
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	public List<com.livebet.domain.Event> getEvents() {
		List<Event> eventList = em.createNamedQuery("Event.findAll")
				.getResultList();

		List<com.livebet.domain.Event> result = new ArrayList<com.livebet.domain.Event>();

		for (Event e : eventList) {
			List<com.livebet.domain.Quote> quotes = new ArrayList<com.livebet.domain.Quote>();
			for (Quote q : e.getQuotes()) {
				logger.log(Level.INFO, "Quote {0}", new Object[] { q.getIdquote() });
				quotes.add(new com.livebet.domain.Quote(q.getIdquote(), q
						.getOutcome(), new AtomicInteger(q.getValue()),
						new AtomicInteger(q.getQuoteversion()), q
								.getTimestamp()));
			}
			result.add(new com.livebet.domain.Event(e.getIdevente(), e
					.getEventname(), e.getOutcome(), quotes));
		}

		return result;
	}

	public boolean deleteEvent(int idevent) {
		try {
			Event event = em.find(Event.class, idevent);
			em.getTransaction().begin();
			em.remove(event);
			em.getTransaction().commit();
			;
			return true;
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	// Quote
	// TODO - list quote attive per evento meglio
	public void createQuote(int idevent, String outcome, int value) {
		try {
			Event event = em.find(Event.class, idevent);
			Quote quote = new Quote();
			quote.setEvent(event);
			quote.setOutcome(outcome);
			quote.setValue(value);
			quote.setBets(new ArrayList<Bet>());
			java.sql.Timestamp ts = new Timestamp(System.currentTimeMillis());
			quote.setTimestamp(ts);
			event.getQuotes().add(quote);
			// em.persist(quote);
			logger.log(Level.INFO, "Created quote {0}-{1}", new Object[] {
					outcome, value });
			// em.persist(quote);
			logger.log(Level.INFO, "Persisted quote {0}-{1}", new Object[] {
					outcome, value });
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	public com.livebet.domain.Quote getQuote(int idquote) {
		try {
			Quote quote = em.find(Quote.class, idquote);
			com.livebet.domain.Quote q = new com.livebet.domain.Quote(
					quote.getIdquote(), quote.getOutcome(), new AtomicInteger(
							quote.getValue()), new AtomicInteger(
							quote.getQuoteversion()), quote.getTimestamp());
			return q;
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	public boolean updateQuote(int idquote, int newvalue) {
		try {
			Quote quote = em.find(Quote.class, idquote);
			if (quote.getValue() != newvalue) {
				quote.setValue(newvalue);
				quote.setQuoteversion(quote.getQuoteversion() + 1);
				java.sql.Timestamp ts = new Timestamp(
						System.currentTimeMillis());
				System.out.println("Timestamp : " + ts);
				quote.setTimestamp(ts);
				return true;
			}
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
		return false;
	}

	// Users
	public boolean userExists(String username) {
		boolean exists = false;
		List<User> results = em.createNamedQuery("User.findUser")
				.setParameter("user", username).getResultList();
		if (!results.isEmpty())
			exists = true;
		return exists;
	}

	public com.livebet.domain.User getUser(String username) {
		List<User> results = em.createNamedQuery("User.findUser")
				.setParameter("user", username).getResultList();
		if (!results.isEmpty()) {
			User u = results.get(0);
			return new com.livebet.domain.User(u.getIduser(), u.getUsername(),
					"", u.getRole());
		}
		return null;
	}

	public Integer getCredit(int iduser) {
		User usertmp = em.find(User.class, iduser);
		return usertmp.getCredit();

	}

	public boolean authenticate(String username, String password) {
		boolean result = false;
		List<User> user = em.createNamedQuery("User.findUserPswd")
				.setParameter("user", username).setParameter("pswd", password)
				.getResultList();
		if (!user.isEmpty()) {
			Date now = new Date();
			user.get(0).setLastseen(now);
			result = true;
		}
		return result;
	}

	public boolean isBookmaker(int iduser) {
		User user = em.find(User.class, iduser);
		if (user.getRole() == "BOOKMAKER")
			return true;
		return false;
	}

	public boolean isBettor(int iduser) {
		User user = em.find(User.class, iduser);
		if (user.getRole() == "BETTOR")
			return true;
		return false;
	}

	public boolean isBettor(String username) {
		List<User> user = em.createNamedQuery("User.findUser")
				.setParameter("user", username).getResultList();
		if (!user.isEmpty()) {
			if (user.get(0).getRole().compareTo("BETTOR") == 0)
				return true;
		}
		return false;
	}

	public boolean isBookmaker(String username) {
		List<User> user = em.createNamedQuery("User.findUser")
				.setParameter("user", username).getResultList();
		if (!user.isEmpty()) {
			if (user.get(0).getRole().compareTo("BOOKMAKER") == 0)
				return true;
		}
		return false;
	}

	// Bet
	public boolean createBet(int idquote, int credit, int iduser) {
		try {
			Quote quote = em.find(Quote.class, idquote);
			User user = em.find(User.class, iduser);
			Bet bet = new Bet();
			bet.setQuote(quote);
			bet.setBetamount(credit);
			bet.setUser(user);
			java.sql.Timestamp ts = new Timestamp(System.currentTimeMillis());
			bet.setTimestamp(ts);
			quote.getBets().add(bet);
			user.getBets().add(bet);
			return true;
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	public List<Bet> getBets(int idquote) {
		try {
			Quote quote = em.find(Quote.class, idquote);
			return quote.getBets();
		} catch (Exception ex) {
			throw new EJBException(ex.getMessage());
		}
	}

	public RequestDAOBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setCredit(int iduser, int newCredit) {
		em.find(User.class, iduser).setCredit(newCredit);
	}

}
