package polytechmontpellier.boi.server.dao.interfaces;

import java.util.ArrayList;

import polytechmontpellier.boi.server.models.User;

public interface UserDAO {

	/**
	 * Query the database to get the user by the pseudo given.
	 * @param pseudo
	 * @return User
	 */
	public User getUserByPseudo(String pseudo);
	public ArrayList<User> findAllFollowedSharps(String pseudo);
	
	
}
