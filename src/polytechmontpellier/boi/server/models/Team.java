package polytechmontpellier.boi.server.models;

public class Team {
	private String name;
	private String location;
	private int sport;

		
		
		public Team(String name, String location, int sport) {
			this.name = name;
			this.location = location;
			this.sport = sport;
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
		
		public int getSport() {
			return sport;
		}

		public void setSport(int sport) {
			this.sport = sport;
		}
}
