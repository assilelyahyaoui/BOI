package polytechmontpellier.boi.factories;

import polytechmontpellier.boi.managers.UserManager;

public class UserManagerFactory {

	/**
	 * @var userManagerFactory
	 */
	private static UserManagerFactory userManagerFactory;
	
	/**
	 * Constructor
	 */
	private UserManagerFactory() {}
	
	/**
	 * Get the instance of UserManagerFactory singleton
	 * @return UserManagerFactory
	 */
	public static UserManagerFactory getInstance() {
		if(userManagerFactory == null) {
			userManagerFactory =  new UserManagerFactory();
		}
		return userManagerFactory;
	}
	
	/**
	 * Provide the UserManager
	 * @return
	 */
	public UserManager getUserManager() {
		return UserManager.getInstance();
	}
	
}
