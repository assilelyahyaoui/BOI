package polytechmontpellier.boi.server.facades;


import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.FactoryType;
import polytechmontpellier.boi.server.factories.AbstractDAOFactory;
import polytechmontpellier.boi.server.models.User;

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
	 * @throws ClassNotFoundException 
	 */
	private AbstractDAOFactory getDAOFactory() throws ClassNotFoundException {
		return AbstractDAOFactory.getFactory(FactoryType.POSTGRES_DAO);
	}
	
	@SuppressWarnings("unchecked")
	public DAO<User> getUserDAO() {
		DAO<User> userDAO = null;
		try {
			userDAO = this.getDAOFactory().getUserDAO();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userDAO;
	}
}
