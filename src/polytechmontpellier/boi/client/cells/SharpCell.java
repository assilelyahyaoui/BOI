package polytechmontpellier.boi.client.cells;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SharpCell {

	private final StringProperty username;
	private final StringProperty numberOfFollowers;
	private final StringProperty numberOfBets;
	private  StringProperty accuracy;
	

	
	public SharpCell(String username, String numberOfBets, String numberOfFollowers) {
		this.username = new SimpleStringProperty(username);
		this.numberOfFollowers = new SimpleStringProperty(numberOfFollowers);
		this.numberOfBets = new SimpleStringProperty(numberOfBets);

	}
 	
	 

	public String getUsername() {
		
		return this.username.getValue();
	}

	public String getNumberOfBets() {
		return this.numberOfBets.getValue();
	} 


	public String getAccuracy() {
		return this.accuracy.getValue();
	}


	public String getNumberOfFollowers() {
		return this.numberOfFollowers.getValue();
	}

	
}
