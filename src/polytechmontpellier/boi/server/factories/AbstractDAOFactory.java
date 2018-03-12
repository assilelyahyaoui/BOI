package polytechmontpellier.boi.server.factories;

import polytechmontpellier.boi.server.dao.interfaces.UserDAO;

public abstract class AbstractDAOFactory {
	public abstract UserDAO getUserDAO();
}
