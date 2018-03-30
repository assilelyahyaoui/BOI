package polytechmontpellier.boi.server.dao.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<User> findAllFollowedSharps(String pseudo) {
		// TODO Auto-generated method stub
//		String query = "SELECT * FROM users u WHERE roleID = 1 ";
		
		String query = "SELECT * FROM Users u WHERE u.userID IN (SELECT f.sharpID FROM Users u1 , Follow f WHERE u1.userID = f.bettorID AND u1.pseudo = '";
		query+=pseudo;
		query+="'";

		
		ResultSet sharps = this.excuteQuery(query);
		sharpsList = null; 
		try {
			while( sharps.next()) {
				System.out.println("sharpList : " ); 
				System.out.println(sharps);
				sharpsList.add((User) sharps); 
			}
				 
			} catch(Exception e) {e.printStackTrace();}
		
		System.out.println("sharpsList");
		System.out.println(sharpsList);
		
		return sharpsList ; 
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
