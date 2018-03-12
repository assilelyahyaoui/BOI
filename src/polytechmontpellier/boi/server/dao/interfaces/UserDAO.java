package polytechmontpellier.boi.server.dao.interfaces;

import java.util.ArrayList;

import polytechmontpellier.boi.server.models.User;

public interface UserDAO {
	
	
	
	public ArrayList<User> findAll();
	public ArrayList<User> findById();
	public ArrayList<User> findByName();
	public boolean insertEmployee(User user);
	public boolean updateEmployee(User user);
	public boolean deleteEmployee(User user);

	/**
	 * Query the database to get the user by the pseudo given.
	 * @param pseudo
	 * @return User
	 */
	public User getUserByPseudo(String pseudo);
	
}
