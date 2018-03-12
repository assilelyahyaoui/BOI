package polytechmontpellier.boi.server.facades;

import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.factories.PostgresDAOFactory;

public class DAOFactoryFacade{
	/**
	 * @var DAOFactory
	 */
	private static DAOFactoryFacade DAOFactory;
	
	/**
	 * Constructor
	 */
	private DAOFactoryFacade() {}
	
	/**
	 * @return DAOFactory
	 */
	public static DAOFactoryFacade getInstance() {
		if(DAOFactory == null) {
			DAOFactory = new DAOFactoryFacade();
		}
		return DAOFactory;
	}
	
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub	
		return PostgresDAOFactory.getInstance().getUserDAO();
	}
}
