package bl;

import java.util.Observable;
import java.util.Observer;

import factories.UserManagerFactory;
import gui.EditableGUI;
import managers.UserManager;

public class Facade implements Observer{

	/**
	 * @var gui EditableGUI
	 */
	private EditableGUI gui;
	
	/**
	 * @var userManager UserManager
	 */
	private UserManager userManager;
	
	/**
	 * Constructor 
	 */
	public Facade() {	
		//Instantiate the user manager
		UserManagerFactory userManagerFactory = UserManagerFactory.getInstance();
		this.userManager = userManagerFactory.getUserManager(); 
		//register the facade as an observer of the user
		this.userManager.addObserver(this);
	}
	
	/**
	 * Implements Observer update method.
	 * @param o Observable that notified the facade.
	 * @param arg Object the message.
	 */
	@Override
	public void update(Observable o, Object msg) {
		// TODO Auto-generated method stub
		this.gui.updateGUI((String) msg);
	}
	
	/**
	 * Delegate the login business logic to the UserManager login method.
	 * @param pseudo
	 * @param password
	 */
	public void login(String pseudo, String password, String role) {
		
		this.userManager.login(pseudo, password, role);	
		
	}

}
