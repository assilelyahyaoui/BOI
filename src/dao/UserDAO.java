package dao;

import java.util.ArrayList;

import models.User;

public interface UserDAO {
	
	/**
	 * Query the database to get the user by the pseudo given.
	 * @param pseudo
	 * @return User
	 */
	
	public ArrayList<User> findAll();
	public ArrayList<User> findById();
	public ArrayList<User> findByName();
	public boolean insertEmployee(User user);
	public boolean updateEmployee(User user);
	public boolean deleteEmployee(User user);

	public User getUserByPseudo(String pseudo);
	
}
