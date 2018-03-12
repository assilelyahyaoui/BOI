package polytechmontpellier.boi.server.dao.models;

import java.util.ArrayList;

import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.models.User;

public class PostgresUserDAO implements UserDAO{

	/**
	 * @var postgresUserDAO
	 */
	private static PostgresUserDAO postgresUserDAO;
	
	/**
	 * Constructor
	 */
	private PostgresUserDAO() {}
	
	public static PostgresUserDAO getInstance() {
		if(postgresUserDAO == null) {
			postgresUserDAO = new PostgresUserDAO();
		}
		return postgresUserDAO;
	}
	
	
	@Override
	public ArrayList<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertEmployee(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByPseudo(String pseudo) {
		// TODO Auto-generated method stub
		return null;
	}

}
