package polytechmontpellier.boi.client.cells;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BetCell {

	private final StringProperty team;
	private final StringProperty bet;
	private final StringProperty pseudo;
	private final StringProperty sport;
	
	public BetCell(String teamName, String bet, String pseudo, String sport) {
		this.team = new SimpleStringProperty(teamName);
		this.bet = new SimpleStringProperty(bet);
		this.pseudo = new SimpleStringProperty(pseudo);
		this.sport = new SimpleStringProperty(sport);

	}
	
	public StringProperty getTeam() {
		return team;
	}
	
	public StringProperty getBet() {
		return bet;
	}
	public StringProperty getPseudo() {
		return pseudo;
	}

	public StringProperty getSport() {
		return sport;
	}
}
