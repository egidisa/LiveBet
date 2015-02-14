package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the EVENT database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idevente;

	private String eventname;

	private String outcome;

	//bi-directional many-to-one association to Quote
	@OneToMany(mappedBy="event", cascade = CascadeType.PERSIST)
	private List<Quote> quotes;

	public Event() {
	}
	
	public Event(String eventName, String outcome){
		this.eventname = eventName;
		this.outcome = outcome;
		this.quotes = new ArrayList<>();
		
	}

	public int getIdevente() {
		return this.idevente;
	}

	public void setIdevente(int idevente) {
		this.idevente = idevente;
	}

	public String getEventname() {
		return this.eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getOutcome() {
		return this.outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public List<Quote> getQuotes() {
		return this.quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}

	public Quote addQuote(Quote quote) {
		getQuotes().add(quote);
		quote.setEvent(this);

		return quote;
	}

	public Quote removeQuote(Quote quote) {
		getQuotes().remove(quote);
		quote.setEvent(null);

		return quote;
	}

}