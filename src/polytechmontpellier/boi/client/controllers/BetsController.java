package polytechmontpellier.boi.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import polytechmontpellier.boi.client.cells.BetCell;
import polytechmontpellier.boi.client.facades.ClientFacade;


public class BetsController implements Initializable {
	
	
	@FXML
	private TableView<BetCell> bets;
	
	@FXML
	private TableColumn team;
	
	@FXML
	private TableColumn sport;
	
	@FXML
	private TableColumn pronostic;
	
	@FXML
	private TableColumn pseudo;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		bets.setEditable(false);
	}
	
	public void fillTableView(Object data) {
		
		JSONArray array = (JSONArray)  data;
			
		ObservableList<BetCell> betCells = FXCollections.observableArrayList();
		for(Object o : array) {
			JSONObject obj = (JSONObject) o;
			try {
				BetCell betCell = new BetCell((String)obj.get("team"),(String)obj.get("pronostic"),(String) obj.get("pseudo"),(String)obj.get("sport"));
				betCells.add(betCell);
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}
		sport.setCellValueFactory(
			   new PropertyValueFactory<BetCell,String>("sport")
		);
		team.setCellValueFactory(
		    new PropertyValueFactory<BetCell,String>("team")
		);
		pseudo.setCellValueFactory(
		    new PropertyValueFactory<BetCell,String>("pseudo")
		);
		pronostic.setCellValueFactory(
		    new PropertyValueFactory<BetCell,String>("pronostic")
		);
			
		
		bets.setItems(betCells);
		bets.getColumns().addAll(team, sport, pseudo,pronostic);
		
	}
	
	
}
