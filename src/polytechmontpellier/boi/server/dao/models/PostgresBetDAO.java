package polytechmontpellier.boi.server.dao.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.interfaces.BetDAO;
import polytechmontpellier.boi.server.factories.PostgreSQLConnection;
import polytechmontpellier.boi.server.models.Bet;
import polytechmontpellier.boi.server.models.User;

public class PostgresBetDAO extends DAO<Bet> implements BetDAO{

	/**
	 * @var pgConnection
	 */
	private Connection pgConnection;
	
	/**
	 * Constructor
	 */
	public PostgresBetDAO() {
		this.pgConnection = PostgreSQLConnection.getConnection();
	}
	
	@Override
	public ArrayList<Bet> findAll() {
		// TODO Auto-generated method stub
		String query = "select u.pseudo, a.pronostic, t.teamname, s.sportname, a.gameid from Advices a, Users u, Include i, Teams t, Sports s\n" + 
				"where a.userid = u.id\n" + 
				"and i.gameid = a.gameid\n" + 
				"and t.teamid = i.teamid\n" + 
				"and t.sportid = s.sportid\n" + 
				"\n";
		
		ResultSet betSet = this.excuteQuery(query);
		ArrayList<Bet> bets = new ArrayList<Bet>();
		try {
			while(betSet.next()) {
				bets.add(new Bet(betSet.getString(1),betSet.getString(2), betSet.getString(3), betSet.getString(4), betSet.getInt(5)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return bets;
	}

	@Override
	public ArrayList<Bet> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Bet> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bet insert(Bet obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Bet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Bet obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Bet> getSharpBets(String sharpPseudo) {
		// TODO Auto-generated method stub
		return null;
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
