package polytechmontpellier.boi.server.models;

public class Sharp {
	private String pseudo;
	private String numberOfFollowers; 
	private String numberOfBets ;
	
	public Sharp(String pseudo ,String numberOfFollowers, String numberOfBets) {
		this.pseudo = pseudo; 
		this.numberOfFollowers = numberOfFollowers; 
		this.numberOfBets = numberOfBets ; 
	 	
	}
	
	
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNumberOfFollowers() {
		return numberOfFollowers;
	}
	public void setNumberOfFollowers(String numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}
	public String getNumberOfBets() {
		return numberOfBets;
	}
	public void setNumberOfBets(String numberOfBets) {
		this.numberOfBets = numberOfBets;
	} 
}
