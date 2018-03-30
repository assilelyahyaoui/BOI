package polytechmontpellier.boi.server.dao.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.interfaces.SharpDAO;
import polytechmontpellier.boi.server.dao.interfaces.UserDAO;
import polytechmontpellier.boi.server.factories.PostgreSQLConnection;
import polytechmontpellier.boi.server.models.Sharp;
import polytechmontpellier.boi.server.models.User;
import polytechmontpellier.boi.server.models.User;


public class PostgresSharpsDAO extends DAO<Sharp> implements SharpDAO{

	/**
	 * @var pgConnection
	 */
	private Connection pgConnection;
	
	/**
	 * Constructor
	 */
	

	public PostgresSharpsDAO() {
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



	@Override
	public ArrayList<Sharp> findById() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public List<Sharp> findAllFollowedSharps(String pseudo) {
		// TODO Auto-generated method stub
		String query = "SELECT u.pseudo FROM Users u WHERE u.id IN (SELECT f.sharpID FROM Users u1 , Follow f WHERE u1.id = f.bettorID AND u1.pseudo = '";
		query+=pseudo;
		query+="')";

		 
		
		ResultSet sharpSet = this.excuteQuery(query);
		
		String query2 = "SELECT u.pseudo, u.id,Count(*) FROM Users u , Follow f WHERE f.sharpID = u.id GROUP BY u.id ";
		ResultSet sharpSet2 = this.excuteQuery(query2);

		String query3 = "SELECT u.pseudo, u.id , Count(*) FROM Users u , Advices a  WHERE a.userID = u.id GROUP BY u.id ";
		ResultSet sharpSet3 = this.excuteQuery(query3);
		
		System.out.println("PSharpsDAO findAllFollowedSharps sharpSet");
		System.out.println("sharpSet " + sharpSet); 
		System.out.println("sharpSet2 " + sharpSet2); 
		System.out.println("sharpSet3 " + sharpSet3); 

		
		List<Sharp> sharps = new ArrayList<Sharp>();
		
		try {
			
			while(sharpSet.next()) {
				Boolean added = false ; 
				System.out.println("sharpSet : " + sharpSet.getString(1));
				while(sharpSet2.next()) {
					System.out.println("sharpSet2 : " + sharpSet2.getString(1));
					System.out.println("if" + sharpSet.getString(1) + sharpSet2.getString(1) );
					if( sharpSet.getString(1).equals(sharpSet2.getString(1) )) {
						System.out.println("dans le if ");
						while(sharpSet3.next()) {
							System.out.println("sharpSet3 : " + sharpSet3.getString(1)); 
							if( sharpSet.getString(1).equals(sharpSet3.getString(1) )) {
								System.out.println("getString 1 " + sharpSet.getString(1));
								System.out.println("getString 2 " + sharpSet2.getString(3));
								System.out.println("getString 3 " + sharpSet3.getString(3));
								
							sharps.add(new Sharp(sharpSet.getString(1) , sharpSet2.getString(3), sharpSet3.getString(3))); 
							added= true ; 
							}
							}
						if (added == false) {
							System.out.println("dans 1er if ");
							sharps.add(new Sharp(sharpSet.getString(1) , sharpSet2.getString(3), "0"));	

						}

						}
				}
				while(sharpSet3.next()) {
					System.out.println("sharpSet3 : " + sharpSet3.getString(1)); 
					if( sharpSet.getString(1).equals(sharpSet3.getString(1) )) {
						System.out.println("getString 1 " + sharpSet.getString(1));
						System.out.println("getString 2 " + sharpSet2.getString(3));
						System.out.println("getString 3 " + sharpSet3.getString(3));
						 sharps.add(new Sharp(sharpSet.getString(1) , "0", sharpSet3.getString(3)));	
					}
					}
				if(added == false) {
					System.out.println("dans 2eme if ");
					 sharps.add(new Sharp(sharpSet.getString(1) , "0", "0"));	

				}
			}
		}
		catch(Exception e) {
			System.out.println("postgresUserDAO catch de array ");
			e.printStackTrace();
		}
    	System.out.println("postgresSharpDAO sharps");
		System.out.println(sharps);
		
		return sharps ; 
	}


	@Override
	public Sharp insert(Sharp obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean update(Sharp obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Sharp obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ArrayList<Sharp> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Sharp> findByName() {
		// TODO Auto-generated method stub
		return null;
	}



	
	
	
}
