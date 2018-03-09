package polytechmontpellier.boi.factories;

import polytechmontpellier.boi.managers.UserManager;

public class ManagerFactory {

	/**
	 * @var managerFactory
	 */
	private static ManagerFactory managerFactory;
	
	/**
	 * Constructor
	 */
	private ManagerFactory() {}
	
	/**
	 * Get the instance of UserManagerFactory singleton
	 * @return UserManagerFactory
	 */
	public static ManagerFactory getInstance() {
		if(managerFactory == null) {
			managerFactory =  new ManagerFactory();
		}
		return managerFactory;
	}
	
	/**
	 * Provide the UserManager
	 * @return
	 */
	public UserManager getUserManager() {
		return UserManager.getInstance();
	}
	
}
