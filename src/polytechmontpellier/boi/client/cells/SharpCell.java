package polytechmontpellier.boi.client.cells;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SharpCell {

	private StringProperty username;
	private StringProperty numberOfFollowers;
	private StringProperty numberOfBets;
	private StringProperty accuracy;
	
	public SharpCell(StringProperty username, StringProperty team2Name, StringProperty numberOfBets, StringProperty accuracy, StringProperty numberOfFollowers) {
		this.setUsername(username);
		this.setNumberOfFollowers(numberOfFollowers);
		this.setNumberOfBets(numberOfBets);
		this.setAccuracy(accuracy);

	}
	
	public SharpCell(String username) {
		this.username = new SimpleStringProperty(username);
	}

	public String getUsername() {
		
		return this.username.getValue();
	}

	public void setUsername(StringProperty username) {
		this.username = username;
	}

	public String getNumberOfBets() {
		return this.numberOfBets.getValue();
	}

	public void setNumberOfBets(StringProperty numberOfBets) {
		this.numberOfBets = numberOfBets;
	}

	public String getAccuracy() {
		return this.accuracy.getValue();
	}

	public void setAccuracy(StringProperty accuracy) {
		this.accuracy = accuracy;
	}

	public String getNumberOfFollowers() {
		return this.numberOfFollowers.getValue();
	}

	public void setNumberOfFollowers(StringProperty numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}
	
}
