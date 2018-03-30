package polytechmontpellier.boi.server.managers;


import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import polytechmontpellier.boi.server.dao.DAO;
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
	private DAO<User> userDAO;
	

	
	/**
	 * Constructor
	 */
	private UserManager() {
		System.out.println("UserManager");
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
		 this.currentUser = ((UserDAO) userDAO).getUserByPseudo(pseudo);
		// Check credentials
		return this.currentUser != null && this.currentUser.getPseudo().equals(pseudo) && this.currentUser.getPassword().equals(password);
		
	
	}
	
	public List<User> findAllFollowedSharps() {
		System.out.println("User manager find allfollowedSharps ");

		List<User> followedSharpList = ((UserDAO) userDAO).findAllFollowedSharps(this.currentUser.getPseudo());
		System.out.println(this.currentUser.getPseudo());
		System.out.println("followedSharpList");
		System.out.println(followedSharpList);
		return followedSharpList ; 
				
	}
	
	public User getUser() {
		return this.currentUser;
	}
}
