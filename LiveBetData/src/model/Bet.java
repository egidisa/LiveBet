package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the BET database table.
 * 
 */
@Entity
@NamedQuery(name="Bet.findAll", query="SELECT b FROM Bet b")
public class Bet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idbet;

	private int betamount;

	//bi-directional many-to-one association to Quote
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="IDQUOTE")
	private Quote quote;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = new Date(timestamp.getTime());
	}

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="IDUSER")
	private User user;

	public Bet() {
	}

	public int getIdbet() {
		return this.idbet;
	}

	public void setIdbet(int idbet) {
		this.idbet = idbet;
	}

	public int getBetamount() {
		return this.betamount;
	}

	public void setBetamount(int betamount) {
		this.betamount = betamount;
	}

	public Quote getQuote() {
		return this.quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}