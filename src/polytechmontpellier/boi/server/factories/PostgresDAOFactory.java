package polytechmontpellier.boi.server.factories;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.models.PostgresUserDAO;
import polytechmontpellier.boi.server.models.User;

public class PostgresDAOFactory extends AbstractDAOFactory {

	@Override
	public DAO<User> getUserDAO() {
		return new PostgresUserDAO();
	}
	
}
