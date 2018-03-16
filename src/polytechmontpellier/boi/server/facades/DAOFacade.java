package polytechmontpellier.boi.server.facades;


import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.factories.AbstractDAOFactory;
import polytechmontpellier.boi.server.factories.PostgresDAOFactory;

public class DAOFacade{

	/**
	 * @var Facade
	 */
	private static DAOFacade facade;

	/**
	 * Constructor 
	 */
	private DAOFacade() {	}
	
	/**
	 * Singleton static access.
	 * @return
	 */
	public static DAOFacade getInstance() {
		if(facade == null) {
			facade =  new DAOFacade();
		}
		return facade;
	}
	
	/**
	 * Handle the persistent layer business logic
	 * @return the DAOFactory of the good persistent layer
	 */
	private AbstractDAOFactory getDAOFactory() {
		// if it is a postgres db
		return PostgresDAOFactory.getInstance();
	}
	
	public UserDAO getUserDAO() {
		return this.getDAOFactory().getUserDAO();
	}
	
	
}
