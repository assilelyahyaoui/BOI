package polytechmontpellier.boi.server.dao.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.interfaces.BetDAO;
import polytechmontpellier.boi.server.dao.interfaces.GameDAO;
import polytechmontpellier.boi.server.factories.PostgreSQLConnection;
import polytechmontpellier.boi.server.models.Bet;
import polytechmontpellier.boi.server.models.Game;

public class PostgresGameDAO extends DAO<Game> implements GameDAO {

	/**
	 * @var pgConnection
	 */
	private Connection pgConnection;
	
	/**
	 * Constructor
	 */
	public PostgresGameDAO() {
		this.pgConnection = PostgreSQLConnection.getConnection();
	}
	
	@Override
	public ArrayList<Game> findAll() {
		// TODO Auto-generated method stub
		String query = "select g.gamedate, t.teamname, i.score, i2.score, t2.teamname from Games g, Teams t, Teams t2, Include i, Include i2\n" + 
				"where g.gameid = i.gameid\n" + 
				"and i.teamid = t.teamid\n" + 
				"and g.gameid = i2.gameid\n" + 
				"and i2.teamid = t2.teamid\n" ;
		
		ResultSet gameSet = this.excuteQuery(query);
		ArrayList<Game> games = new ArrayList<Game>();
		try {
			while(gameSet.next()) {
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				String stringDate = df.format(gameSet.getDate(1));
				System.out.println(gameSet.getDate(1)+ gameSet.getString(2) +  gameSet.getString(5));
				games.add(new Game(stringDate,gameSet.getString(2), gameSet.getInt(3), gameSet.getInt(4), gameSet.getString(5)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return games;
	}

	@Override
	public ArrayList<Game> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Game> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game insert(Game obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Game obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Game obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Game> getGames() {
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
