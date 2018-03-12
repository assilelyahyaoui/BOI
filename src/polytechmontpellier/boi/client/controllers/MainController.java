package polytechmontpellier.boi.client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import polytechmontpellier.boi.client.BOIGui;

public class MainController implements Initializable, BOIGui{

	/**
	 * Handle the GUI login.
	 * @var loginController LoginController
	 */
	private LoginController loginController;
	
	/**
	 * Constructor.
	 * Instanciate the loginController
	 * @param primaryStage Stage 
	 * @throws IOException
	 */
	public MainController(Stage primaryStage) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("/polytechmontpellier/boi/client/view/Login.fxml"));
        
		loginController = new LoginController();
		loginController.setParentController(this);
		
		root.setController(loginController);
        Parent parent = root.load();
		Scene scene = new Scene(parent);
        primaryStage.setTitle("BOI - Bet On It | Login");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		loginController.setParentController(this);
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
			// Change to main scene
		}else if(action.equals("BAD_CREDENTIALS")) {
			//display error message
		}
		System.out.println(action);
		
	}

}
