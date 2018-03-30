package polytechmontpellier.boi.server.managers;


import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.dao.interfaces.*;

import polytechmontpellier.boi.server.facades.DAOFacade;
import polytechmontpellier.boi.server.models.*;

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
	private DAO<Sharp> sharpDAO;
	

	
	/**
	 * Constructor
	 */
	private UserManager() {
		this.userDAO = DAOFacade.getInstance().getUserDAO();
		this.sharpDAO = DAOFacade.getInstance().getSharpDAO();
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
	
	public List<Sharp> findAllFollowedSharps() {

		List<Sharp> followedSharpList = ((SharpDAO) sharpDAO).findAllFollowedSharps(this.currentUser.getPseudo());
		return followedSharpList ; 
				
	}
	
	public User getUser() {
		return this.currentUser;
	}
	
	public boolean makePremium(String pseudo) {
		return ((UserDAO) userDAO).makePremium(pseudo);
	}
}
