package polytechmontpellier.boi.client.cells;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BetCell {

	private final StringProperty team;
	private final StringProperty pronostic;
	private final StringProperty pseudo;
	private final StringProperty sport;
	
	public BetCell(String teamName, String bet, String pseudo, String sport) {
		this.team = new SimpleStringProperty(teamName);
		this.pronostic = new SimpleStringProperty(bet);
		this.pseudo = new SimpleStringProperty(pseudo);
		this.sport = new SimpleStringProperty(sport);

	}
	
	public String getTeam() {
		return team.getValue();
	}
	
	public String getPronostic() {
		return pronostic.getValue();
	}
	public String getPseudo() {
		return pseudo.getValue();
	}

	public String getSport() {
		return sport.getValue();
	}
}
