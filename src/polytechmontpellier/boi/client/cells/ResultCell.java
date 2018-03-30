package polytechmontpellier.boi.client.cells;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ResultCell {
	private final StringProperty gameDate ;
	private final StringProperty firstTeam;
	private final IntegerProperty firstScore;
	private final IntegerProperty secondScore;
	private final StringProperty secondTeam;
	
	public ResultCell(String date, String firstTeam, int firstScore, int secondScore, String secondTeam) {
		this.gameDate = new SimpleStringProperty(date);
		this.firstTeam = new SimpleStringProperty(firstTeam);
		this.firstScore = new SimpleIntegerProperty(firstScore);
		this.secondScore = new SimpleIntegerProperty(secondScore);
		this.secondTeam = new SimpleStringProperty(secondTeam);

	}
	
	public StringProperty getFirstTeam() {
		return firstTeam;
	}
	
	public StringProperty getSecondTeam() {
		return secondTeam;
	}
	
	public StringProperty getDate() {
		return gameDate;
	}
	public IntegerProperty getFirstScore() {
		return firstScore;
	}

	public IntegerProperty getSecondScore() {
		return secondScore;
	}
}
