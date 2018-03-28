package polytechmontpellier.boi.client.facades;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.lloseng.ocsf.client.ObservableClient;

import polytechmontpellier.boi.client.BOIGui;

public class ClientFacade implements Observer{
	
	/**
	 * For singleton implementation
	 * @var Facade
	 */
	private static ClientFacade facade;
	
	/**
	 * BOI gui. 
	 */
	private BOIGui boiGui; 
	
	/**
	 * server host.
	 * @var DEFAULT_HOST
	 */
	private final String DEFAULT_HOST = "localhost";
	
	
	/**
	 * server port.
	 * @var DEFAULT_PORT 
	 */
	private final int DEFAULT_PORT = 8080;
	
	/**
	 * @var observableClient OCSF ObservableClient
	 */
	private ObservableClient observableClient;
	
	/**
	 * Constructor 
	 */
	private ClientFacade() {	
		//Instantiate the user manager
		this.observableClient = new ObservableClient(DEFAULT_HOST,DEFAULT_PORT);
		this.observableClient.addObserver(this);
		
		//Open the connection with the server.
		try {
			this.observableClient.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.boiGui = boiGui;
		
	}
	
	/**
	 * Only way to get an instance of client facade
	 * @return ClientFacade
	 */
	public static ClientFacade getInstance() {
		if(facade == null) {
			facade =  new ClientFacade();
		}
		
		return facade;
	}
	
	public void setGUI(BOIGui gui) {
		this.boiGui = gui;
	}
	
	
	/**
	 * Delegate the login request.
	 * @param pseudo
	 * @param password
	 */
	public void login(String pseudo, String password) {		
		try {
			JSONObject json = new JSONObject();
			
			try {
				json.put("password",password);
				json.put("pseudo", pseudo);
				json.put("action", "LOGIN");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.observableClient.sendToServer(json.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getBets(){
		JSONObject json = new JSONObject();
		try {
			json.put("action", "GET_BETS");
			this.observableClient.sendToServer(json.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void displayAllFollowedSharps()  {
		try {
			JSONObject json = new JSONObject();
			json.put("action","DISPLAY_ALL_SHARPS" ); 
			this.observableClient.sendToServer(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Business logic to handle messages sent by the server.
	 * @param msg
	 * @return void
	 */
	private void handleMessageFromServer(String msg) {
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(msg);
			this.boiGui.updateGUI((String) json.get("action"), json.get("data"));
		}catch(Exception e) {
			this.boiGui.updateGUI(msg, null);
		}
		
	}

	/**
	 * Observer update method Implementation
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(arg instanceof Exception){
			System.out.println("Exception");
			((Exception) arg).printStackTrace();
		}else{
			String msg = (String) arg;
			
		    if(msg.equals(ObservableClient.CONNECTION_CLOSED)){
		    	
				System.out.println("ConnectionClosed");
		    	
		    }else if(msg.equals(ObservableClient.CONNECTION_ESTABLISHED)){
		    	
				System.out.println("Conenection established");
		    	
		    }else{
				this.handleMessageFromServer((String) arg);
		    }
		}
				
	}

}
