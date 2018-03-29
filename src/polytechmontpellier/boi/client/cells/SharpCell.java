package polytechmontpellier.boi.client.cells;

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

	public StringProperty getUsername() {
		return username;
	}

	public void setUsername(StringProperty username) {
		this.username = username;
	}

	public StringProperty getNumberOfBets() {
		return numberOfBets;
	}

	public void setNumberOfBets(StringProperty numberOfBets) {
		this.numberOfBets = numberOfBets;
	}

	public StringProperty getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(StringProperty accuracy) {
		this.accuracy = accuracy;
	}

	public StringProperty getNumberOfFollowers() {
		return numberOfFollowers;
	}

	public void setNumberOfFollowers(StringProperty numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}
	
}
