package polytechmontpellier.boi.server.managers;

import java.util.ArrayList;
import java.util.List;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.dao.models.PostgresGameDAO;
import polytechmontpellier.boi.server.facades.DAOFacade;
import polytechmontpellier.boi.server.models.Bet;
import polytechmontpellier.boi.server.models.Game;

public class GameManager {
	/**
	 * @var gameManager GameManager
	 */
	private static GameManager gameManager;
	
	/**
	 * Link between the User model and the database User table.
	 * @var userDAO UserDAO
	 */
	private DAO<Game> gameDAO;
	
	
	/**
	 * Constructor
	 */
	private GameManager() {
		this.gameDAO = DAOFacade.getInstance().getGameDAO();
	}
	
	public static GameManager getInstance() {
		if(gameManager == null) {
			gameManager =  new GameManager();
		}
		return gameManager;
	}
	
	public List<Game> getGames(){
		ArrayList<Game> games = this.gameDAO.findAll();
	
		int i = 0;
		
		while(i< games.size() ) {
			Game g  = games.get(i);
			System.out.print(g.getTeamHome());
		//	b.setTeam(b.getTeam() + " vs " + bets.get(i+1).getTeam());
	//		processedBets.add(b);
	//		i+= 2;
			i++;
		}
		return  games;
	}
	
	public List<Game> getFutureGames() {
		ArrayList<Game> games = ((PostgresGameDAO) this.gameDAO).getFutureGames();
		return  games;
	}
	
}
