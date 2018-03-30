package polytechmontpellier.boi.server.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

import polytechmontpellier.boi.server.models.*;

public interface UserDAO {

	/**
	 * Query the database to get the user by the pseudo given.
	 * @param pseudo
	 * @return User
	 */
	public User getUserByPseudo(String pseudo);
	//public List<?> findAllFollowedSharps(String pseudo);
	public boolean makePremium(String pseudo);
	
	
}
