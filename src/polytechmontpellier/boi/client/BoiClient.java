package polytechmontpellier.boi.client;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import polytechmontpellier.boi.client.controllers.MainController;
import polytechmontpellier.boi.client.facades.ClientFacade;

public class BoiClient extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Instantiate MainController
		// Handles the business logic between scenes.
		MainController mainController = new MainController(primaryStage);
		// TODO Auto-generated method stub
		
		
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
