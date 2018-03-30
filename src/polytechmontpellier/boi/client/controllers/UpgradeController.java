package polytechmontpellier.boi.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import polytechmontpellier.boi.client.facades.ClientFacade;

public class UpgradeController implements Initializable {
	
	@FXML
	private Button upgradeBtn;
	
	@FXML
	private Label statusLabel;

	private ClientFacade facade;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		this.facade = ClientFacade.getInstance();
	}
	public void setButtonListener() {
		this.upgradeBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				upgradePremium();
			}	
		});
	}
	
	public void upgradePremium() {
		this.facade.makePremium();
		//this.facade.getResults();
	}

}
