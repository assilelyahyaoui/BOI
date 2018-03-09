package factories;

import managers.UserManager;

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
		return (userManagerFactory != null) ? userManagerFactory : new UserManagerFactory();
	}
	
	/**
	 * Provide the UserManager
	 * @return
	 */
	public UserManager getUserManager() {
		return UserManager.getInstance();
	}
	
}
