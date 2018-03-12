package polytechmontpellier.boi.server.managers;


import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.facades.DAOFactoryFacade;
import polytechmontpellier.boi.server.models.User;

public class UserManager{

	/**
	 * @var UserManager
	 */
	private static UserManager userManager;
	
	/**
	 * @var currentUser User
	 */
	private User currentUser;
	
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
		if(userManager == null) {
			
			userManager = new UserManager(DAOFactoryFacade.getInstance().getUserDAO());
		}
		return userManager;
	}
	
	/**
	 * Login business logic
	 * @param pseudo
	 * @param password
	 */
	public boolean login(String pseudo, String password) {
		// Get the user with the pseudo given.
		 this.currentUser = userDAO.getUserByPseudo(pseudo);
		// Check credentials
		return this.currentUser != null && this.currentUser.getPseudo() == pseudo && this.currentUser.getPassword() == password;
		
	
	}
}
