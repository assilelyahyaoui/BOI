package polytechmontpellier.boi.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import polytechmontpellier.boi.client.cells.*;
import polytechmontpellier.boi.client.facades.ClientFacade;

public class SharpsController implements Initializable {

	
	private TableView<SharpCell> sharpsTV;

	@FXML
	private TableColumn username;
	
	@FXML
	private TableColumn numberOfFollowers;
	
	@FXML
	private TableColumn numberOfBets;
	
	@FXML
	private TableColumn accuracy;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		sharpsTV.setEditable(false);
		ClientFacade.getInstance().displayAllFollowedSharps();
		System.out.println("sharpsController");
	}
	
	
	public void fillTableView(Object data) {
		System.out.println("SharpsController fill tableView");
		JSONArray array = (JSONArray) data;
		
		ObservableList<SharpCell> sharpCells = FXCollections.observableArrayList();
		for(Object o : array) {
			JSONObject obj = (JSONObject) o;
			try {
				SharpCell sharpCell = new SharpCell((StringProperty) obj.get("username"), (StringProperty)obj.get("numberOfFollowers"),(StringProperty) obj.get("numberOfBets"), (StringProperty)obj.get("accuracy"), null);
				sharpCells.add(sharpCell);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		username.setCellValueFactory(
			   new PropertyValueFactory<SharpCell,String>("username")
		);
		/*numberOfFollowers.setCellValueFactory(
		    new PropertyValueFactory<SharpCell,String>("numberOfFollowers")
		);
		numberOfBets.setCellValueFactory(
		    new PropertyValueFactory<SharpCell,String>("numberOfBets")
		);
		accuracy.setCellValueFactory(
		    new PropertyValueFactory<SharpCell,String>("accuracy")
		);*/
		
		sharpsTV.setItems(sharpCells);
    }
}
