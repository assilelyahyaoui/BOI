package polytechmontpellier.boi.server.factories;

import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.dao.models.PostgresUserDAO;

public class PostgresDAOFactory extends AbstractDAOFactory {

	
	/**
	 * @var postgresDAOFactory
	 */
	private static PostgresDAOFactory postgresDAOFactory;
	
	/**
	 * Constructor
	 */
	private PostgresDAOFactory() {}
	
	/**
	 * @return PostgresDAOFactory
	 */
	public static PostgresDAOFactory getInstance() {
		if(postgresDAOFactory == null) {
			postgresDAOFactory = new PostgresDAOFactory();
		}
		return postgresDAOFactory;
	}
	
	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		
		
		return PostgresUserDAO.getInstance();
	}

}
