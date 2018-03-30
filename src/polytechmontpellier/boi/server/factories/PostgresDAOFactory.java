package polytechmontpellier.boi.server.factories;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.models.PostgresBetDAO;
import polytechmontpellier.boi.server.dao.models.PostgresGameDAO;
import polytechmontpellier.boi.server.dao.models.PostgresSharpsDAO;
import polytechmontpellier.boi.server.dao.models.PostgresUserDAO;
import polytechmontpellier.boi.server.models.Bet;
import polytechmontpellier.boi.server.models.Game;
import polytechmontpellier.boi.server.models.User;
import polytechmontpellier.boi.server.models.*;


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
	
	public  DAO<Sharp> getSharpsDAO(){
		// TODO Auto-generated method stub
		return new PostgresSharpsDAO(); 
	}
	
	@Override
	public DAO<Game> getGameDAO() {
		// TODO Auto-generated method stub
		return new PostgresGameDAO();
	}
}
