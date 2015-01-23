package com.livebet.domain;

import java.util.Date;

public class Match {
	Integer id;
	Date matchDate;
	String team1;
	String team2;
	int scoreTeam1;
	int scoreTeam2;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getD() {
		return matchDate;
	}

	public void setD(Date d) {
		this.matchDate = d;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public int getScoreTeam1() {
		return scoreTeam1;
	}

	public void setScoreTeam1(int scoreTeam1) {
		this.scoreTeam1 = scoreTeam1;
	}

	public int getScoreTeam2() {
		return scoreTeam2;
	}

	public void setScoreTeam2(int scoreTeam2) {
		this.scoreTeam2 = scoreTeam2;
	}

}
