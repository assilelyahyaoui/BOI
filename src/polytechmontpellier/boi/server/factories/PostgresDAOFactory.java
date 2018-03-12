package polytechmontpellier.boi.server.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.dao.models.PostgresUserDAO;

public class PostgresDAOFactory extends AbstractDAOFactory {

	
	/**
	 * @var postgresDAOFactory
	 */
	private static PostgresDAOFactory postgresDAOFactory;
	
	/**
	 * Constructor
	 */
	private PostgresDAOFactory() {}
	
	/**
	 * @return PostgresDAOFactory
	 */
	public static PostgresDAOFactory getInstance() {
		if(postgresDAOFactory == null) {
			postgresDAOFactory = new PostgresDAOFactory();
		}
		return postgresDAOFactory;
	}
	
	public Connection getPostgresConnection() {
		String url = "jdbc:postgresql://localhost:5432/BetOnIt";
        String user = "postgres";
        String password = "admin";
        Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		
		return PostgresUserDAO.getInstance(getPostgresConnection());
	}

}
