package polytechmontpellier.boi.client;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import polytechmontpellier.boi.client.controllers.LoginController;
import polytechmontpellier.boi.client.facades.ClientFacade;

public class BoiClient extends Application{

	/**
	 * Handle the GUI login.
	 * @var loginController LoginController
	 */
	private LoginController loginController;
	
	/**
	 * Handle the Bets.
	 * @var betsController betsController
	 */
	//private BetsController betsController;
	
	/**
	 * Contains the view.
	 * @var Stage primaryStage
	 */
	private Stage stage;
	
	/**
	 * Facade to hide the communication logic.
	 * @var facade ClientFacade.
	 */
	private ClientFacade facade;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Instantiate MainController
		// Handles the business logic between scenes.
		// TODO Auto-generated method stub
		
		
		// Load the first view.
		this.stage = primaryStage;
		FXMLLoader root = new FXMLLoader(getClass().getResource("/polytechmontpellier/boi/client/view/RootView.fxml"));		
		
        Parent parent = root.load();
		Scene scene = new Scene(parent);
        this.stage.setTitle("BOI - Bet On It");
        this.stage.setScene(scene);
        this.stage.show();
        
	}
	
	
	
	/**
	 * Launch the app.
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		// Launch the graphical user interface.
		BoiClient.launch(args);

	}
	
	
}
