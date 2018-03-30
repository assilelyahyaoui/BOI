package polytechmontpellier.boi.client.cells;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameCell {
	
	private StringProperty gameDate ;
	private StringProperty teamHome;
	private StringProperty teamAway;
	private StringProperty gameLocation;
	private StringProperty gameSport;
	
	public GameCell(String date, String teamHome, String teamAway, String gameLocation, String gameSport) {
		this.gameDate = new SimpleStringProperty(date);
		this.teamHome = new SimpleStringProperty(teamHome);
		this.teamAway = new SimpleStringProperty(teamAway);
		this.gameLocation = new SimpleStringProperty(gameLocation);
		this.gameSport = new SimpleStringProperty(gameSport);

	}
	
	public String getTeamHome() {
		return this.teamHome.getValue();
	}
	
	public String getTeamAway() {
		return this.teamAway.getValue();
	}
	
	public String getGameDate() {
		return gameDate.getValue();
	}
	public String getGameLocation() {
		return this.gameLocation.getValue();
	}

	public String getGameSport() {
		return this.gameSport.getValue();
	}

}
