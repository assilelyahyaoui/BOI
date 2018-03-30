package polytechmontpellier.boi.client.controllers;

import java.util.HashMap;
import java.util.Map;

import javafx.stage.Stage;

public class ScreenController {
	private static ScreenController instance;  
	
	
	   public static ScreenController getInstance(){  
	     return instance == null ? new ScreenController() : instance;  
	   }  
	   private static Map<String, Object> screenControllerObjects = new HashMap<String, Object>(); 
	   
	   private static Stage currentStage; 
	   
	   
	   public Map<String, Object> getScreenControllerObjects(){  
	     return screenControllerObjects;  
	   }  
	   public Object getScreenControllerObject(String key){  
	     return screenControllerObjects.get(key);  
	   }  
	   public Object removeScreenControllerObject(String key){  
	     return screenControllerObjects.remove(key);  
	   }  
	   public void addScreenControllerObject(String key, Object value){  
		   screenControllerObjects.put(key, value);  
	   }  
	   public void clearScreenControllerObjects(){  
		   screenControllerObjects.clear();  
	   }  
	   public Stage getCurrentStage() {  
	     return currentStage;  
	   }  
	   public void setCurrentStage(Stage stage) {  
	     currentStage = stage;  
	   }  
}
