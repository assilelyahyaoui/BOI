package polytechmontpellier.boi.server.factories;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.FactoryType;
import polytechmontpellier.boi.server.models.Bet;
import polytechmontpellier.boi.server.models.User;

public abstract class AbstractDAOFactory {
	public abstract DAO<User> getUserDAO();
	public abstract DAO<Bet> getBetDAO();
	
	public static AbstractDAOFactory getFactory(FactoryType type) {
		
		if(type.equals(FactoryType.POSTGRES_DAO)) {
			return new PostgresDAOFactory();
		}
		
		return null;
	}
}
