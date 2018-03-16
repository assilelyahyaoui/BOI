package polytechmontpellier.boi.server.managers;


import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.facades.DAOFacade;
import polytechmontpellier.boi.server.models.User;

public class UserManager{

	/**
	 * @var userManager UserManager
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
	private UserManager() {
		this.userDAO = DAOFacade.getInstance().getUserDAO();
	}
	
	public static UserManager getInstance() {
		if(userManager == null) {
			userManager =  new UserManager();
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
		return this.currentUser != null && this.currentUser.getPseudo().equals(pseudo) && this.currentUser.getPassword().equals(password);
		
	
	}
}
