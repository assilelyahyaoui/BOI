package polytechmontpellier.boi.client.controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import polytechmontpellier.boi.client.cells.BetCell;
import polytechmontpellier.boi.client.cells.ResultCell;
import polytechmontpellier.boi.client.facades.ClientFacade;

public class ResultsController implements Initializable {

	@FXML
	private TableView<ResultCell> results;
	
	@FXML
	private TableColumn gameDate;
	
	@FXML
	private TableColumn firstTeam;
	
	@FXML
	private TableColumn firstScore;
	
	@FXML
	private TableColumn secondScore;
	
	@FXML
	private TableColumn secondTeam;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		results.setEditable(false);
	}
	
	public void fillTableView(Object data) {
		System.out.println("fill tableView");
		JSONArray array = (JSONArray) data;
		
		ObservableList<ResultCell> resultCells = FXCollections.observableArrayList();
		for(Object o : array) {
			JSONObject obj = (JSONObject) o;
			try {
				ResultCell resultCell = new ResultCell((String)obj.get("date"), (String)obj.get("firstTeam"),((Long) obj.get("firstScore")).intValue(), ((Long)obj.get("secondScore")).intValue(),(String)obj.get("secondTeam"));
				resultCells.add(resultCell);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		gameDate.setCellValueFactory(
			   new PropertyValueFactory<ResultCell,Date>("gameDate")
		);
		firstTeam.setCellValueFactory(
		    new PropertyValueFactory<ResultCell,String>("firstTeam")
		);
		firstScore.setCellValueFactory(
		    new PropertyValueFactory<ResultCell,Integer>("firstScore")
		);
		secondScore.setCellValueFactory(
		    new PropertyValueFactory<ResultCell,Integer>("secondScore")
		);
		
		secondTeam.setCellValueFactory(
			    new PropertyValueFactory<ResultCell,String>("secondTeam")
			);
		
		results.setItems(resultCells);
		results.getColumns().addAll(gameDate, firstTeam, firstScore,secondScore,secondTeam);
	}

}
