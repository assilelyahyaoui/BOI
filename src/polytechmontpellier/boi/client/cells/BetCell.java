package polytechmontpellier.boi.client.cells;

import javafx.beans.property.StringProperty;

public class BetCell {

	private StringProperty team1;
	private StringProperty team2;
	private StringProperty bet;
	private StringProperty percentage;
	
	public BetCell(StringProperty team1Name, StringProperty team2Name, StringProperty bet, StringProperty percentage) {
		this.team1 = team1Name;
		this.team2 = team2Name;
		this.bet = bet;
		this.percentage = percentage;

	}
	
	public StringProperty getTeam1() {
		return team1;
	}
	public void setTeam1(StringProperty team1) {
		this.team1 = team1;
	}
	public StringProperty getTeam2() {
		return team2;
	}
	public void setTeam2(StringProperty team2) {
		this.team2 = team2;
	}
	public StringProperty getBet() {
		return bet;
	}
	public void setBet(StringProperty bet) {
		this.bet = bet;
	}
	public StringProperty getPercentage() {
		return percentage;
	}
	public void setPercentage(StringProperty percentage) {
		this.percentage = percentage;
	}
}
