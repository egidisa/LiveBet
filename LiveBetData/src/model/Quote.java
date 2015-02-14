package model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the QUOTE database table.
 * 
 */
@Entity
@NamedQuery(name="Quote.findAll", query="SELECT q FROM Quote q")
public class Quote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idquote;

	private String outcome;

	private int quoteversion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	private int value;

	//bi-directional many-to-one association to Bet
	@OneToMany(mappedBy="quote", cascade = CascadeType.PERSIST)
	private List<Bet> bets;

	//bi-directional many-to-one association to Event
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="IDEVENT")
	private Event event;

	public Quote() {
	}
	
//	public Quote(String outcome, int value){
//		//this.event = event;
//		this.outcome = outcome;
//		this.value = value;
//		//this.bets = new ArrayList<>();
//		this.quoteversion = 1;
//		this.timestamp = new Date(System.currentTimeMillis());
//		
//	}

	public int getIdquote() {
		return this.idquote;
	}

	public void setIdquote(int idquote) {
		this.idquote = idquote;
	}

	public String getOutcome() {
		return this.outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public int getQuoteversion() {
		return this.quoteversion;
	}

	public void setQuoteversion(int quoteversion) {
		this.quoteversion = quoteversion;
	}

	public Date getTimestamp() {
		return  this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = new Date(timestamp.getTime());
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Bet> getBets() {
		return this.bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	public Bet addBet(Bet bet) {
		getBets().add(bet);
		bet.setQuote(this);

		return bet;
	}

	public Bet removeBet(Bet bet) {
		getBets().remove(bet);
		bet.setQuote(null);

		return bet;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}