package polytechmontpellier.boi.server.dao.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.factories.PostgreSQLConnection;
import polytechmontpellier.boi.server.models.*;

public class PostgresUserDAO extends DAO<User> implements UserDAO {
	
	/**
	 * @var pgConnection
	 */
	private Connection pgConnection;
	private ArrayList<User> sharpsList;

	
	/**
	 * Constructor
	 */
	public PostgresUserDAO() {
		this.pgConnection = PostgreSQLConnection.getConnection();
	}
	
	public ArrayList<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<User> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<User> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	public User insert(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(User user) {
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

	/*
	@Override
	public List<Sharp> findAllFollowedSharps(String pseudo) {
		// TODO Auto-generated method stub
		System.out.println("PostgresUsereDAO finndALLfollowed vide");
		return null;
	}
*/
	
	/*public List<Sharp> findAllFollowedSharps(String pseudo) {
		// TODO Auto-generated method stub
		String query = "SELECT u.pseudo FROM Users u WHERE u.id IN (SELECT f.sharpID FROM Users u1 , Follow f WHERE u1.id = f.bettorID AND u1.pseudo = '";
		query+=pseudo;
		query+="')";

		 
		
		ResultSet sharpSet = this.excuteQuery(query);
		ArrayList<User> sharps = new ArrayList<User>();
		
		try {
			while(sharpSet.next()) {
				while(sharpSet2.next()) {
					if( sharpSet.getString(1) == sharpSet2.getString(1) ) {
						while(sharpSet3.next()) {
							sharps.add(new Sharp(sharpSet.getString(1), sharpSet2.getString(3), sharpSet3.getString(3)));	
						}
					}
					
				
				}
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return sharps ; 
	}
*/
	@Override
	public boolean makePremium(String pseudo) {
		// TODO Auto-generated method stub		
		String query = "UPDATE Users SET role_id=(SELECT id FROM Users where label='PREMIUM') WHERE pseudo='"+ pseudo+"'";
		this.excuteQuery(query);
		return true;
		
	}

	@Override
	public List<User> findAllFollowedSharps(String pseudo) {
		// TODO Auto-generated method stub
		return null;
	}

}
