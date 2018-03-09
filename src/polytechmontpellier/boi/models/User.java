package polytechmontpellier.boi.models;

public class User{

	/**
	 * @var pseudo String
	 */
	private String pseudo;
	
	/**
	 * @var password String
	 */
	private String password;
	
	/**
	 * @var role String
	 */
	private String role;
	
	/**
	 * Constructor
	 */
	public User(String pseudo, String password, String role) {
		this.pseudo = pseudo;
		this.password  = password;
		this.role = role;
	}
	
	/**
	 * Constructor
	 */
	public User() {}
	
	/************************ GETTERS *****************************/
	public String getPseudo() {
		return this.pseudo;
	}
	public String getPassword() {
		return this.password;
	}
	public String getRole() {
		return this.role;
	}
	
	/************************* SETTERS ****************************/
	
	public void setPseudo(String p) {
		this.pseudo = p;
	}
	public void setPassword(String p) {
		this.password = p;
	}
	public void setRole(String r) {
		this.role = r;
	}
}
