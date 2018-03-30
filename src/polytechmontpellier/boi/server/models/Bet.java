package polytechmontpellier.boi.server.models;

public class Bet {

	private String pronostic;
	private String team;
	private String sportName;
	private String pseudo;
	
	
	public Bet(String pro, String team, String sport, String ps) {
		this.pronostic = pro;
		this.team = team;
		this.sportName = sport;
		this.pseudo = ps;
	}
	public String getPronostic() {
		return pronostic;
	}

	public void setPronostic(String pronostic) {
		this.pronostic = pronostic;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
}
