package polytechmontpellier.boi.server.models;

public class Team {
	
	private String name;
	private String location;
	private String sport;
	
	public Team(String name) {
		this.name = name;
	}
	
	public Team(String teamName, String teamLocation, String sport) {
		this.setName(teamName);
		this.setLocation(teamLocation);
		this.setSport(sport);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

}
