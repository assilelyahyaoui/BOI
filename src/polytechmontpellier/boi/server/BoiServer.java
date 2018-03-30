package polytechmontpellier.boi.server;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.lloseng.ocsf.server.ConnectionToClient;
import com.lloseng.ocsf.server.ObservableOriginatorServer;
import com.lloseng.ocsf.server.OriginatorMessage;

import polytechmontpellier.boi.server.facades.ServerFacade;
import polytechmontpellier.boi.server.models.Bet;
import polytechmontpellier.boi.server.models.Game;

@SuppressWarnings("deprecation")
public class BoiServer implements Observer{
	
	/**
	 * Le fichier de configuration.
	 */
	public final static String PROPERTIES_FILE = "configuration/configuration.properties";

	/**
	 * @var DEFAULT_PORT int
	 */
	private final int DEFAULT_PORT = 8080;
	
	/**
	 * @var observableServer ObservableOriginatorServer
	 */
	private ObservableOriginatorServer observableServer;
	
	/**
	 * @var facade ServerFacade 
	 */
	private ServerFacade facade;
	
	/**
	 * Constructor
	 */
	public BoiServer() {
		
		this.facade = ServerFacade.getInstance();
		this.observableServer = new ObservableOriginatorServer(DEFAULT_PORT);
		this.observableServer.addObserver(this);
		
		
	}
	
	/**
	 * Starts server's listening.
	 */
	public void listen() {
		try {
			this.observableServer.listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Handle the server business logic.
	 * @param msg the message sent by the client.
	 * @param client that sent the message.
	 * @throws IOException 
	 */
	private void handleMessageFromClient(Object msg, ConnectionToClient client) throws IOException {
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject data = (JSONObject) parser.parse((String) msg);

			if(data.get("action").equals("LOGIN")) { 
				// User wants to login
				if(this.facade.login((String)data.get("pseudo"),(String)data.get("password"))) {
					//credentials are good.
					client.setInfo("pseudo", data.get("pseudo"));
					client.setInfo("password",data.get("password"));
					client.sendToClient("LOGGED_IN");
				}else {
					client.sendToClient("BAD_CREDENTIALS");
				
				}

			}else if(data.get("action").equals("GET_BETS")) {
				List<Bet> bets = facade.getBets();
				try {
					JSONObject json = new JSONObject();
					json.put("action", "GET_BETS");
					JSONArray array = new JSONArray();
					for(Bet b : bets) {
						JSONObject j = new JSONObject();
						j.put("team", b.getTeam());
						j.put("sport", b.getSportName());
						j.put("pronostic", b.getPronostic());
						j.put("pseudo", b.getPseudo());
						array.add(j);
					}
					json.put("data", array);
					
					client.sendToClient(json.toString());
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(data.get("action").equals("GET_RESULTS")) {
				System.out.println("test result");
				List<Game> games = facade.getGames();
				try {
					JSONObject json = new JSONObject();
					json.put("action", "GET_RESULTS");
					JSONArray array = new JSONArray();
					for(Game g : games) {
						JSONObject j = new JSONObject();
						j.put("date", g.getDate());
						j.put("firstTeam", g.getFirstTeam());
						j.put("firstScore", g.getFirstScore());
						j.put("secondTeam", g.getSecondTeam());
						j.put("secondScore", g.getSecondScore());
						array.add(j);
					}
					json.put("data", array);
					
					System.out.println(json.toString());
					client.sendToClient(json.toString());
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(data.get("action").equals("MAKE_PREMIUM")) {
				if(this.facade.makePremium(client.getInfo("pseudo"))) {
					client.sendToClient("IS_PREMIUM");
				}else {
					client.sendToClient("IS_NOT_PREMIUM");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	   * Hook method called each time a new client connection is
	   * accepted. The default implementation does nothing.
	   * This method does not have to be synchronized since only
	   * one client can be accepted at a time.
	   *
	   * @param client the connection connected to the client.
	   */
	  protected void clientConnected(ConnectionToClient client) {}

	  /**
	   * Hook method called each time a client disconnects.
	   * The client is garantee to be disconnected but the thread
	   * is still active until it is asynchronously removed from the thread group. 
	   * The default implementation does nothing. The method
	   * may be overridden by subclasses but should remains synchronized.
	   *
	   * @param client the connection with the client.
	   */
	  synchronized protected void clientDisconnected(
	    ConnectionToClient client) {}

	  /**
	   * Hook method called each time an exception is thrown in a
	   * ConnectionToClient thread.
	   * The method may be overridden by subclasses but should remains
	   * synchronized. 
	   * Most exceptions will cause the end of the client's thread except for
	   * <code>ClassNotFoundException<\code>s received when an object of
	   * unknown class is received and for the <code>RuntimeException</code>s
	   * that can be thrown by the message handling method implemented by the user.
	   *
	   * @param client the client that raised the exception.
	   * @param Throwable the exception thrown.
	   */
	  synchronized protected void clientException(
	    ConnectionToClient client, Throwable exception) {
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  /**
	   * Hook method called when the server stops accepting
	   * connections because an exception has been raised.
	   * The default implementation does nothing.
	   * This method may be overriden by subclasses.
	   *
	   * @param exception the exception raised.
	   */
	  protected void listeningException(Throwable exception) {
		  this.observableServer.sendToAllClients("LISTENING_ERROR");
	  }

	  /**
	   * Hook method called when the server starts listening for
	   * connections.  The default implementation does nothing.
	   * The method may be overridden by subclasses.
	   */
	  protected void serverStarted() {
		  System.out.println("Server Started");
	  }

	  /**
	   * Hook method called when the server stops accepting
	   * connections.  The default implementation
	   * does nothing. This method may be overriden by subclasses.
	   */
	  protected void serverStopped() {
		  System.out.println("Server Stopped");
	  }

	  /**
	   * Hook method called when the server is clased.
	   * The default implementation does nothing. This method may be
	   * overriden by subclasses. When the server is closed while still
	   * listening, serverStopped() will also be called.
	   */
	  protected void serverClosed() {
		  System.out.println("Server Closed");
	  }

		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
			OriginatorMessage msg = (OriginatorMessage) arg;

			if(((String)msg.getMessage()).startsWith(ObservableOriginatorServer.CLIENT_EXCEPTION)){
				
				this.clientException(msg.getOriginator(),new Exception((String)msg.getMessage()));
				
			}else{
				
				switch((String) msg.getMessage()){
					case ObservableOriginatorServer.CLIENT_CONNECTED : this.clientConnected(msg.getOriginator());break;
					case ObservableOriginatorServer.CLIENT_DISCONNECTED : this.clientDisconnected(msg.getOriginator());break;
					case ObservableOriginatorServer.LISTENING_EXCEPTION : this.listeningException(new Throwable((Exception) arg));break;
					case ObservableOriginatorServer.SERVER_CLOSED: this.serverClosed();break;
					case ObservableOriginatorServer.SERVER_STARTED: this.serverStarted();break;
					case ObservableOriginatorServer.SERVER_STOPPED: this.serverStopped();break;
					default : try {
						this.handleMessageFromClient(msg.getMessage(),msg.getOriginator());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			
		}
		
		
		/**
		 * Class method 
		 * Launches the server.
		 */
		public static void main(String[] args) {
			BoiServer boi = new BoiServer();
			boi.listen();
			
		}

}
