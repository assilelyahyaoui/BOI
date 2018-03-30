package polytechmontpellier.boi.server.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import polytechmontpellier.boi.server.dao.DAO;
import polytechmontpellier.boi.server.facades.DAOFacade;
import polytechmontpellier.boi.server.models.Bet;

public class BetManager {

	/**
	 * @var betManager BetManager
	 */
	private static BetManager betManager;
	
	/**
	 * Link between the User model and the database User table.
	 * @var userDAO UserDAO
	 */
	private DAO<Bet> betDAO;
	
	
	/**
	 * Constructor
	 */
	private BetManager() {
		this.betDAO = DAOFacade.getInstance().getBetDAO();
	}
	
	public static BetManager getInstance() {
		if(betManager == null) {
			betManager =  new BetManager();
		}
		return betManager;
	}
	
	public List<Bet> getBets(){
		return this.getBets(0);
	}
	public List<Bet> getBets(int nb){
		ArrayList<Bet> bets = this.betDAO.findAll();
		ArrayList<Bet> processedBets = new ArrayList<Bet>();
		int i = 0;
		int j = 0;
		while(i< bets.size() && j < 5) {
			Bet b  = bets.get(i);
			if(b.getTeam() != bets.get(i+1).getTeam()) {
				b.setTeam(b.getTeam() + " vs " + bets.get(i+1).getTeam());
				processedBets.add(b);
				if(nb > 0) {
					j++;
				}
			}
			
			i+= 2;
		}
		return  processedBets;
	}
}
