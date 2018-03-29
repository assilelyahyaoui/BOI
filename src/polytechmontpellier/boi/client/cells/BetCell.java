package polytechmontpellier.boi.client.cells;

import javafx.beans.property.StringProperty;

public class BetCell {

	private StringProperty team;
	private StringProperty bet;
	private StringProperty pseudo;
	private StringProperty sport;
	
	public BetCell(StringProperty teamName, StringProperty bet, StringProperty pseudo, StringProperty sport) {
		this.team = teamName;
		this.bet = bet;
		this.pseudo = pseudo;
		this.sport = sport;

	}
	
	public StringProperty getTeam1() {
		return team;
	}
	public void setTeam1(StringProperty team) {
		this.team = team;
	}
	public StringProperty getBet() {
		return bet;
	}
	public void setBet(StringProperty bet) {
		this.bet = bet;
	}
	public StringProperty getPseudo() {
		return pseudo;
	}
	public void setPseudo(StringProperty pseudo) {
		this.pseudo = pseudo;
	}

	public StringProperty getSport() {
		return sport;
	}

	public void setSport(StringProperty sport) {
		this.sport = sport;
	}
}
