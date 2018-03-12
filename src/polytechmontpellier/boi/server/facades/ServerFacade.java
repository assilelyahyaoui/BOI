package polytechmontpellier.boi.server.facades;

import polytechmontpellier.boi.server.factories.ManagerFactory;
import polytechmontpellier.boi.server.managers.UserManager;

public class ServerFacade{
	
	/**
	 * @var Facade
	 */
	private static ServerFacade facade;

	/**
	 * @var userManager UserManager
	 */
	private UserManager userManager;
	
	/**
	 * Constructor 
	 */
	private ServerFacade() {	
		//Instantiate the user manager
		ManagerFactory userManagerFactory = ManagerFactory.getInstance();
		this.userManager = userManagerFactory.getUserManager(); 
	}
	

	public static ServerFacade getInstance() {
		if(facade == null) {
			facade =  new ServerFacade();
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
