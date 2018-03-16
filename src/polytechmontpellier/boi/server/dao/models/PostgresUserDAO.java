package polytechmontpellier.boi.server.dao.models;

import java.sql.*;
import java.util.ArrayList;

import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.models.User;

public class PostgresUserDAO implements UserDAO{

	/**
	 * @var postgresUserDAO
	 */
	private static PostgresUserDAO postgresUserDAO;
	
	/**
	 * @var pgConnection
	 */
	private Connection pgConnection;
	/**
	 * Constructor
	 */
	private PostgresUserDAO(Connection connection) {
		this.pgConnection = connection;
	}
	
	public static PostgresUserDAO getInstance(Connection connection) {
		if(postgresUserDAO == null) {
			postgresUserDAO = new PostgresUserDAO(connection);
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
		String query = "SELECT u.pseudo, u.password, r.label FROM users u, roles r WHERE u.pseudo ='";
		query+=pseudo;
		query+="'";
		query+= " AND u.role_id = r.id";
		
		ResultSet users = this.excuteQuery(query);
		User user = null;
		try {
			users.next();
			user = new User(users.getString(1),users.getString(2), users.getString(3));
		}
		catch(Exception e) {}
		
		return user;
	}
	
	private ResultSet excuteQuery(String query) {
		try {
            Statement state = this.pgConnection.createStatement();
            ResultSet result = state.executeQuery(query);
            return result;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
	}


}
