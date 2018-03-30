package polytechmontpellier.boi.server.models;

import java.util.Date;

public class Game {
	private String date;
	private String firstTeam;
	private int firstScore;
	private String secondTeam;
	private int secondScore;
	
	
	public Game(String date, String firstTeam, int firstScore, int secondScore, String secondTeam) {
		this.date = date;
		this.setFirstTeam(firstTeam);
		this.setFirstScore(firstScore);
		this.setSecondScore(secondScore);
		this.setSecondTeam(secondTeam);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFirstTeam() {
		return firstTeam;
	}

	public void setFirstTeam(String firstTeam) {
		this.firstTeam = firstTeam;
	}

	public int getFirstScore() {
		return firstScore;
	}

	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}

	public String getSecondTeam() {
		return secondTeam;
	}

	public void setSecondTeam(String secondTeam) {
		this.secondTeam = secondTeam;
	}

	public int getSecondScore() {
		return secondScore;
	}

	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}


}
