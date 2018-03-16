package polytechmontpellier.boi.server.facades;


import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.factories.AbstractDAOFactory;
import polytechmontpellier.boi.server.factories.PostgresDAOFactory;
import polytechmontpellier.boi.server.managers.UserManager;

public class DAOFactoryFacade{

	/**
	 * @var Facade
	 */
	private static DAOFactoryFacade facade;

	/**
	 * Constructor 
	 */
	private DAOFactoryFacade() {	}
	
	/**
	 * Singleton static access.
	 * @return
	 */
	public static DAOFactoryFacade getInstance() {
		if(facade == null) {
			facade =  new DAOFactoryFacade();
		}
		return facade;
	}
	
	/**
	 * Handle the persistent layer business logic
	 * @return
	 */
	private AbstractDAOFactory getDAOFactory() {
		// if it is a postgres db
		return PostgresDAOFactory.getInstance();
	}
	
	public UserDAO getUserDAO() {
		return this.getDAOFactory().getUserDAO();
	}
	
	
}
