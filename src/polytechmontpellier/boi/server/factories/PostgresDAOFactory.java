package polytechmontpellier.boi.server.factories;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.models.PostgresBetDAO;
import polytechmontpellier.boi.server.dao.models.PostgresGameDAO;
import polytechmontpellier.boi.server.dao.models.PostgresUserDAO;
import polytechmontpellier.boi.server.models.Bet;
import polytechmontpellier.boi.server.models.Game;
import polytechmontpellier.boi.server.models.User;

public class PostgresDAOFactory extends AbstractDAOFactory {

	@Override
	public DAO<User> getUserDAO() {
		return new PostgresUserDAO();
	}

	@Override
	public DAO<Bet> getBetDAO() {
		// TODO Auto-generated method stub
		return new PostgresBetDAO();
	}
	
	@Override
	public DAO<Game> getGameDAO() {
		// TODO Auto-generated method stub
		return new PostgresGameDAO();
	}
}
