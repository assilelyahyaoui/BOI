package polytechmontpellier.boi.client;

import polytechmontpellier.boi.client.facades.ClientFacade;

public class BoiClient implements BOIGui{

	/**
	 * @var clientFacade ClientFacade
	 */
	private ClientFacade clientFacade;
	
	/**
	 * Constructor
	 */
	public BoiClient() {
		this.clientFacade = ClientFacade.getInstance(this);
	}

	/**
	 * @param action String that defines what is the action to perform on the UI.
	 * @param data Object, potential data sent by the server.
	 * @return void.
	 */
	@Override
	public void updateGUI(String action, Object data) {
		// TODO Auto-generated method stub
		if(action.equals("LOGGED_IN")) {
			System.out.println("I am logged In");
		}
		
	}
	
	
	
	/**
	 * Launch the app.
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		// Launch the graphical user interface.
		BoiClient boi = new BoiClient();
		boi.clientFacade.login("lolo", "pwd");
	}
}
