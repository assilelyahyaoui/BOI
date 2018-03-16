package polytechmontpellier.boi.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import polytechmontpellier.boi.client.facades.ClientFacade;

public class LoginController implements Initializable {
	
	@FXML
	private Button loginButton;
	
	@FXML
	private TextField pseudo;
	
	@FXML
	private TextField password;
	
	@FXML
	private Label feedBack;
	
	private MainController parentController;
	
	public void login() {
		
		ClientFacade facade = ClientFacade.getInstance(this.parentController);
		if(this.pseudo.getText().equals("") || this.password.getText().equals("")){
			this.showMessage("You have to fill the inputs.");
		}else {
			facade.login(this.pseudo.getText(), this.password.getText());
		}
	}
	
	public void setParentController(MainController parentController) {
	    this.parentController = parentController;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	public void showMessage(String msg) {
		this.feedBack.backgroundProperty().set(new Background(new BackgroundFill(Color.web("#f44242"), null, null)));
		this.feedBack.setTextFill(Color.WHITE);
		this.feedBack.setText(msg);
	}


}
