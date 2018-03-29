package polytechmontpellier.boi.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import polytechmontpellier.boi.client.cells.BetCell;
import polytechmontpellier.boi.client.facades.ClientFacade;


public class BetsController implements Initializable {
	
	
	@FXML
	private TableView<BetCell> bets;
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		ClientFacade.getInstance().getBets();
	}
	
	public void fillTableView(Object data) {
		System.out.println("fill tableView");
	}
	
	
}
