package polytechmontpellier.boi.client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import polytechmontpellier.boi.client.BOIGui;
import polytechmontpellier.boi.client.facades.ClientFacade;

public class RootViewController implements Initializable, BOIGui{

	
	@FXML
	private Button betButton;
	
	@FXML
	private Button gamesButton;
	
	@FXML
	private Button resultsButton;
	
	@FXML
	private Button sharpsButton;
	
	@FXML
	private Button upgradeButton;
	
	@FXML
	private AnchorPane container;

	@FXML
	private LoginController loginCtrl;
	
	@FXML
	private BetsController betsCtrl;
	
	@FXML
	private ResultsController resultsCtrl;
	
	@FXML
	private GamesController gamesCtrl;

	@FXML
	private SharpsController sharpsCtrl;
	
	@FXML
	private UpgradeController upgradeCtrl;

	// Loaders
	private FXMLLoader betsLoader;
	private FXMLLoader gamesLoader;
	private FXMLLoader resultsLoader;
	private FXMLLoader sharpsLoader;
	private FXMLLoader upgradeLoader;
	
	// Nodes
	private Node betsNode;
	private Node gamesNode;
	private Node resultsNode;
	private Node sharpsNode;
	private Node upgradeNode;
	
	private ClientFacade facade;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Set apps loaders and controllers
		
		this.setLoadersAndControllers();
		// Set the login view first.
		Node node;
		try {
			node = (Node) FXMLLoader.load(getClass().getResource("/polytechmontpellier/boi/client/view/Login.fxml"));
			this.container.getChildren().setAll(node);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Add elements not necessary for the login.
		this.hideElements();
		
		//Register the listener on the button
		this.setButtonListener();
		
		// Register RootViewController as the handler of the app UI.
		this.facade = ClientFacade.getInstance();
		this.facade.setGUI(this);
	}
	
	public void hideElements() {
		this.betButton.setVisible(false);
		this.sharpsButton.setVisible(false);
		this.gamesButton.setVisible(false);
		this.resultsButton.setVisible(false);
		this.upgradeButton.setVisible(false);
	}
	public void showElements() {
		this.betButton.setVisible(true);
		this.sharpsButton.setVisible(true);
		this.gamesButton.setVisible(true);
		this.resultsButton.setVisible(true);
		this.upgradeButton.setVisible(true);
	}

	
	public void setLoadersAndControllers() {
		try {
			this.betsLoader = new FXMLLoader(getClass().getResource("/polytechmontpellier/boi/client/view/Bets.fxml"));
			this.betsNode = (Node) this.betsLoader.load();
			this.betsCtrl = betsLoader.getController();
			this.gamesLoader = new FXMLLoader(getClass().getResource("/polytechmontpellier/boi/client/view/Games.fxml"));
			this.gamesNode = (Node) this.gamesLoader.load();
			this.gamesCtrl = gamesLoader.getController();
			this.resultsLoader = new FXMLLoader(getClass().getResource("/polytechmontpellier/boi/client/view/Results.fxml"));
			this.resultsNode = (Node) this.resultsLoader.load();
			this.resultsCtrl = resultsLoader.getController();
			this.sharpsLoader = new FXMLLoader(getClass().getResource("/polytechmontpellier/boi/client/view/getAllSharps.fxml"));
			this.sharpsNode = (Node) this.sharpsLoader.load();
			this.sharpsCtrl = sharpsLoader.getController();
			this.upgradeLoader = new FXMLLoader(getClass().getResource("/polytechmontpellier/boi/client/view/Upgrade.fxml"));
			this.upgradeNode = (Node) this.upgradeLoader.load();
			this.upgradeCtrl = upgradeLoader.getController();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void displayBets() {
		container.getChildren().clear();
		container.getChildren().setAll(this.betsNode);
		this.facade.getBets();
	}
	
	public void displaySharps() {
		container.getChildren().clear();
		container.getChildren().setAll(this.sharpsNode);
		this.facade.getSharps(); 
	}
	
	public void displayGames() {
		container.getChildren().clear();
		container.getChildren().setAll(this.gamesNode);
	}
	
	public void displayResults() {
		container.getChildren().clear();
		container.getChildren().setAll(this.resultsNode);
		this.facade.getResults();
	}
	
	public void displayFutureGames() {
		System.out.println("\n\n");
		System.out.println("Get future games");
		System.out.println("\n\n");
		container.getChildren().clear();
		container.getChildren().setAll(this.gamesNode);
		this.facade.getFutureGames();
	}
	
	public void displayUpgrade() {
		container.getChildren().clear();
		container.getChildren().setAll(this.upgradeNode);
		//this.facade.getResults();
	}
	
	public void setButtonListener() {
		//Register the listener on the button
		this.betButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
				
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
			
				displayBets();
			}	
		});
		this.sharpsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				displaySharps();
			}	
		});
		this.gamesButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("\n\n");
				System.out.println("Get future games");
				System.out.println("\n\n");
				displayFutureGames();
			}	
		});
		this.resultsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
			
				displayResults();
			}	
		});
		this.upgradeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
			
				displayUpgrade();
			}	
		});
				
	}

	/**
	 * @param action String that defines what is the action to perform on the UI.
	 * @param data Object, potential data sent by the server.
	 * @return void.
	 */
	@Override
	public void updateGUI(String action, Object data) {
		
		Platform.runLater(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(action.equals("LOGGED_IN")) {
					
					showElements();
					displayBets();
					
				}else if(action.equals("BAD_CREDENTIALS")) {
					
					//display error message
					Label text = (Label)((AnchorPane)container.getChildren().get(0)).getChildren().get(3);
					text.setText("Bad Credentials");
					text.backgroundProperty().set(new Background(new BackgroundFill(Color.web("#f44242"), null, null)));

				}else if(action.equals("GET_BETS")) {
					System.out.println(data);
					System.out.println(betsCtrl);
					betsCtrl.fillTableView(data);
				}else if(action.equals("GET_RESULTS")) {
					resultsCtrl.fillTableView(data);
				}else if(action.equals("GET_FUTURE_GAMES")) {
					System.out.println("Fetching future games");
					System.out.println(data.toString());
					gamesCtrl.fillTableView(data);
				}else if(action.equals("IS_PREMIUM")) {

					facade.getBets();
					
				}else if(action.equals("IS_NOT_PREMIUM")) {
					System.out.println("Cannot make sharp premium.");
						
				}else if(action.equals("DISPLAY_ALL_SHARPS")) {
					System.out.println("rootViewC , run()");
					System.out.println(data);
					System.out.println(sharpsCtrl);
					sharpsCtrl.fillTableView(data);
				}
				
			}
		});		
	}

}
