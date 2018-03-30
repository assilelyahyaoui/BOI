
package polytechmontpellier.boi.server.models;

import java.sql.Date;

public class Game {
	
	private Team teamHome;
	private Team teamAway;
	private Date date;
	private int firstScore;
	private int secondScore;
	
	public Game(Team home, Team away, Date date) {
		this.setTeamHome(home);
		this.setTeamAway(away);
		this.setDate(date);
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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.teamHome.getName());
		sb.append(" - ");
		sb.append(this.teamAway.getName());
		return sb.toString();
	}
	
}
