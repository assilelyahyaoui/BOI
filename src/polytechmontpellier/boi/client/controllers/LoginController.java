package polytechmontpellier.boi.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import polytechmontpellier.boi.client.facades.ClientFacade;

public class LoginController implements Initializable {
	
	@FXML
	private Button loginButton;
	
	@FXML
	private TextField pseudo;
	
	@FXML
	private TextField password;
	
	private MainController parentController;
	
	public void login() {
		
		ClientFacade facade = ClientFacade.getInstance(this.parentController);
		facade.login(this.pseudo.getText(), this.password.getText());
	}
	
	public void setParentController(MainController parentController) {
	    this.parentController = parentController;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}


}
