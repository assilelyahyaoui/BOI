package polytechmontpellier.boi.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.*;



import polytechmontpellier.boi.client.facades.ClientFacade;


public class SharpsListController implements Initializable {
	private MainController parentController ; 
	
	
	public void setParentController(MainController parentController) {
	    this.parentController = parentController;
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public void displayAllFollowedSharps() {
		ClientFacade facade = ClientFacade.getInstance(this.parentController);
		facade.displayAllFollowedSharps();
	}
}
