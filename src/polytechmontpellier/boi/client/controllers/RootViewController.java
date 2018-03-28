package polytechmontpellier.boi.client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import polytechmontpellier.boi.client.BOIGui;
import polytechmontpellier.boi.client.facades.ClientFacade;

public class RootViewController implements Initializable, BOIGui{

	
	@FXML
	private Button betButton;
	
	@FXML
	private AnchorPane container;

	private LoginController loginCtrl;
	
	private BetsController betsCtrl;
	
	private ClientFacade facade;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		//Instanciate controllers
		this.instanciateControllers();
		
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
		this.betButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

		
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
			
				displayBets();
			}
			
		});
		
		// Register RootViewController as the handler of the app UI.
		this.facade = ClientFacade.getInstance(this);
	}
	
	public void hideElements() {
		this.betButton.setVisible(false);
	}
	public void showElements() {
		this.betButton.setVisible(true);
	}
	public void instanciateControllers() {
		this.loginCtrl = new LoginController();
		this.betsCtrl = new BetsController();
	}
	
	public void displayBets() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/polytechmontpellier/boi/client/view/Bets.fxml"));
			loader.setController(this.loginCtrl);
			Node node = (Node) loader.load();
			container.getChildren().setAll(node);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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

					

				}
			}
		});
		// TODO Auto-generated method stub
		
		
	}

}
