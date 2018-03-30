package polytechmontpellier.boi.server.models;

import java.sql.Date;

public class Game {
	
	private Team teamHome;
	private Team teamAway;
	private int firstScore;
	private int secondScore;
	private Date date;

	public Game(Team home, Team away, Date date) {
		this.teamHome = home;
		this.teamAway = away;
		this.date = date;
	}
	
	public Game(Team home, Team away, int firstScore, int secondScore, Date date) {
		this.teamHome = home;
		this.teamAway = away;
		this.setFirstScore(firstScore);
		this.setSecondScore(secondScore);
		this.date = date;
	}

	public Team getTeamHome() {
		return teamHome;
	}

	public void setTeamHome(Team teamHome) {
		this.teamHome = teamHome;
	}

	public Team getTeamAway() {
		return teamAway;
	}

	public void setTeamAway(Team teamAway) {
		this.teamAway = teamAway;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getFirstScore() {
		return firstScore;
	}

	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.teamHome.getName());
		sb.append(" - ");
		sb.append(this.teamAway.getName());
		return sb.toString();
	}
	
}
