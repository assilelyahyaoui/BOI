package polytechmontpellier.boi.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import polytechmontpellier.boi.client.cells.GameCell;
import polytechmontpellier.boi.client.cells.ResultCell;

public class GamesController implements Initializable{

	@FXML
	private TableView<GameCell> games;
	
	@FXML
	private TableColumn gameDate;
	
	@FXML
	private TableColumn teamHome;
	
	@FXML
	private TableColumn teamAway;
	
	@FXML
	private TableColumn gameLocation;
	
	@FXML
	private TableColumn gameSport;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		games.setEditable(false);
	}
	
	public void fillTableView(Object data) {
		System.out.println("fill tableView");
		JSONArray array = (JSONArray) data;
		
		ObservableList<GameCell> gameCells = FXCollections.observableArrayList();
		for(Object o : array) {
			JSONObject obj = (JSONObject) o;
			try {
				GameCell gameCell = new GameCell((String) obj.get("date"), (String) obj.get("teamHome"), (String) obj.get("teamAway"), (String) obj.get("location"), (String) obj.get("sport"));
				gameCells.add(gameCell);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		gameDate.setCellValueFactory(
			   new PropertyValueFactory<GameCell,String>("gameDate")
		);
		teamHome.setCellValueFactory(
		    new PropertyValueFactory<GameCell,String>("teamHome")
		);
		teamAway.setCellValueFactory(
		    new PropertyValueFactory<GameCell,Integer>("teamAway")
		);
		gameLocation.setCellValueFactory(
		    new PropertyValueFactory<GameCell,Integer>("gameLocation")
		);
		
		gameSport.setCellValueFactory(
			    new PropertyValueFactory<GameCell,String>("gameSport")
			);
		
		games.setItems(gameCells);
	}

}
