package polytechmontpellier.boi.server.dao.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.factories.PostgreSQLConnection;
import polytechmontpellier.boi.server.models.User;

public class PostgresBettorDAO extends PostgresUserDAO implements UserDAO {


	/**
	 * @var pgConnection
	 */
	private Connection pgConnection;
	private ArrayList<User> sharpsList;
	
	/**
	 * Constructor
	 */
	public PostgresBettorDAO() {
		this.pgConnection = PostgreSQLConnection.getConnection();
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
