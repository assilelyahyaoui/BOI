package polytechmontpellier.boi.server.factories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import polytechmontpellier.boi.server.BoiServer;

public class PostgreSQLConnection {
	
	/**
	 * postgresDAOFactory
	 */
	private static Connection connection;
	
	/**
	 * DB driver
	 */
	private static String driver;
	
	/**
	 * DB URL
	 */
	private static String url;
	
	/**
	 * username
	 */
	private static String user;
	
	/**
	 * password
	 */
	private static String password;
	
	/**
	 * Constructor
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private static void getProperties() {
		Properties proprietes = new Properties();
		try {
			proprietes.load(new FileInputStream(BoiServer.PROPERTIES_FILE));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		driver = proprietes.getProperty("driver");
		url = proprietes.getProperty("url");
		user = proprietes.getProperty("user");
		password = proprietes.getProperty("password");
	}
	
	public static Connection getConnection() {
		if (connection == null) {
			getProperties();
			try {
	            Class.forName(driver);
	        } 
			catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
			try {
				connection = DriverManager.getConnection(url, user, password);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
