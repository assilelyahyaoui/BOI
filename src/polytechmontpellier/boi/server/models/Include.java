package polytechmontpellier.boi.server.models;

import java.sql.Date;

public class Include {
private int game;
private int team;
private int score;

	
	
	public Include(int g, int t, int score) {
		this.game = g;
		this.team = t;
		this.score = score;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int t) {
		this.team = t;
	}
	
	public int getGame() {
		return game;
	}

	public void setGame(int g) {
		this.game = g;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
