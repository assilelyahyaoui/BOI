package polytechmontpellier.boi.server.facades;

import java.util.List;

import polytechmontpellier.boi.server.managers.BetManager;
import polytechmontpellier.boi.server.managers.GameManager;
import polytechmontpellier.boi.server.managers.UserManager;
import polytechmontpellier.boi.server.models.Bet;
import polytechmontpellier.boi.server.models.Sharp;
import polytechmontpellier.boi.server.models.Game;
import polytechmontpellier.boi.server.models.User;

public class ServerFacade{
	
	/**
	 * @var Facade
	 */
	private static ServerFacade facade;

	/**
	 * @var userManager UserManager
	 */
	private UserManager userManager;
	
	/**
	 * @var betManager BetManager;
	 */
	private BetManager betManager;
	
	/**
	 * @var gameManager GameManager;
	 */
	private GameManager gameManager;
	
	/**
	 * Constructor 
	 */
	private ServerFacade() {	
		//Instantiate the user manager
		this.userManager = UserManager.getInstance(); 
		this.betManager = BetManager.getInstance();
		this.gameManager = GameManager.getInstance();
	}
	

	public static ServerFacade getInstance() {
		if(facade == null) {
			facade =  new ServerFacade();
		}
		
		return facade;
	}
	
	/**
	 * Delegate the login business logic to the UserManager login method.
	 * @param pseudo
	 * @param password
	 */
	public boolean login(String pseudo, String password) {
		return this.userManager.login(pseudo, password);	
	}
	
	public List<Bet> getBets(){
		if(this.userManager.getUser().getRole().equals("PREMIUM")) {
			return this.betManager.getBets();

		}else {
			return this.betManager.getBets(5);
		}
	}
	public boolean makePremium(String pseudo) {
		return this.userManager.makePremium(pseudo);
	}

	public List<User> findAllFollowedSharps() {
		return this.userManager.findAllFollowedSharps();
	}
	public List<Game> getGames(){
		return this.gameManager.getGames();
	}

}
