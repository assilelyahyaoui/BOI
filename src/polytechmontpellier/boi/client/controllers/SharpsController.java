package polytechmontpellier.boi.client.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import polytechmontpellier.boi.client.cells.*;

public class SharpsController implements Initializable {

	
	private TableView<SharpCell> sharpsTV;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void fillTableView(Object data) {
		System.out.println("fill tableView");
	}
	

}
