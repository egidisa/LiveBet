package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findUser", query="SELECT u FROM User u WHERE u.username = :user"),
	@NamedQuery(name="User.findUserPswd", query="SELECT u FROM User u WHERE u.username = :user AND"+" u.password = :pswd"),
})

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduser;

	private int credit;

	@Temporal(TemporalType.DATE)
	private Date lastseen;

	private String password;
	
	private String role;

	private String username;

	//bi-directional many-to-one association to Bet
	@OneToMany(mappedBy="user")
	private List<Bet> bets;

	public User() {
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public int getCredit() {
		return this.credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Date getLastseen() {
		return this.lastseen;
	}

	public void setLastseen(Date lastseen) {
		this.lastseen = lastseen;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Bet> getBets() {
		return this.bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	public Bet addBet(Bet bet) {
		getBets().add(bet);
		bet.setUser(this);

		return bet;
	}

	public Bet removeBet(Bet bet) {
		getBets().remove(bet);
		bet.setUser(null);

		return bet;
	}

}