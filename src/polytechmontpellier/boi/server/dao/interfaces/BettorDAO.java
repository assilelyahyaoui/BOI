package polytechmontpellier.boi.server.dao.interfaces;



import polytechmontpellier.boi.server.models.User;

public interface BettorDAO {

	/**
	 * Query the database to get the all sharps that the bettor has followed by the pseudo given.
	 * @param pseudo
	 * @return User
	 */
	public User getUserByPseudo(String pseudo);
	
}