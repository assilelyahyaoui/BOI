package polytechmontpellier.boi.facades;

import polytechmontpellier.boi.factories.ManagerFactory;
import polytechmontpellier.boi.managers.UserManager;

public class ManagerFacade{
	
	/**
	 * @var Facade
	 */
	private static ManagerFacade facade;

	/**
	 * @var userManager UserManager
	 */
	private UserManager userManager;
	
	/**
	 * Constructor 
	 */
	private ManagerFacade() {	
		//Instantiate the user manager
		ManagerFactory userManagerFactory = ManagerFactory.getInstance();
		this.userManager = userManagerFactory.getUserManager(); 
	}
	

	public static ManagerFacade getInstance() {
		if(facade == null) {
			facade =  new ManagerFacade();
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
