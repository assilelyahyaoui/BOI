package polytechmontpellier.boi.factories;

import polytechmontpellier.boi.dao.interfaces.UserDAO;

public abstract class AbstractDAOFactory {
	public abstract UserDAO getUserDAO();
}
