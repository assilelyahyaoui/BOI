package polytechmontpellier.boi.server.facades;

import java.util.List;

import polytechmontpellier.boi.server.managers.BetManager;
import polytechmontpellier.boi.server.managers.UserManager;
import polytechmontpellier.boi.server.models.Bet;

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
	 * Constructor 
	 */
	private ServerFacade() {	
		//Instantiate the user manager
		this.userManager = UserManager.getInstance(); 
		this.betManager = BetManager.getInstance();
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
		return this.betManager.getBets();
	}

}
