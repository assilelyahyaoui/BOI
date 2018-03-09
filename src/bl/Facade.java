package bl;

import factories.UserManagerFactory;
import managers.UserManager;

public class Facade{
	
	/**
	 * @var Facade
	 */
	private static Facade facade;

	/**
	 * @var userManager UserManager
	 */
	private UserManager userManager;
	
	/**
	 * Constructor 
	 */
	private Facade() {	
		//Instantiate the user manager
		UserManagerFactory userManagerFactory = UserManagerFactory.getInstance();
		this.userManager = userManagerFactory.getUserManager(); 
	}
	

	public static Facade getInstance() {
		if(facade == null) {
			facade =  new Facade();
		}
		
		return facade;
	}
	/**
	 * Delegate the login business logic to the UserManager login method.
	 * @param pseudo
	 * @param password
	 */
	public boolean login(String pseudo, String password) {
		
		return this.userManager.login(pseudo, password);	
		
	}

}
