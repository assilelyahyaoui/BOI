package managers;

import java.util.Observable;

import dao.UserDAO;
import models.User;

public class UserManager extends Observable{

	/**
	 * @var UserManager
	 */
	private static UserManager userManager;
	/**
	 * Link between the User model and the database User table.
	 * @var userDAO UserDAO
	 */
	private UserDAO userDAO;
	
	/**
	 * Constructor
	 */
	private UserManager(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	/**
	 * Implements the singleton pattern
	 */
	public static UserManager getInstance() {
		return (userManager != null) ? userManager : new UserManager(new UserDAO());
	}
	
	/**
	 * Login business logic
	 * @param pseudo
	 * @param password
	 */
	public void login(String pseudo, String password, String role) {
		// Get the user with the pseudo given.
		User user = userDAO.getUserByPseudo(pseudo);
		// Check credentials
		boolean loggedIn = user != null && user.getPseudo() == pseudo && user.getPassword() == password && user.getRole() == role ;
		
		//Notify observer 
		this.setChanged();
		if(loggedIn) {
			this.notifyObservers("LOGGED_IN");
		}else {
			this.notifyObservers("BAD_CREDENTIALS");
		}
	}
}
