package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class HomeSceneController {
	
	@FXML
	private Button logoutBtn;

	// Event Listener on Button.onAction
	@FXML
	public void handleExit(ActionEvent event) {
		Stage currentStage = (Stage) logoutBtn.getScene().getWindow();
	    currentStage.hide();
	    
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginScene.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	@FXML
	private Button Rec;

	// Event Listener on Button.onAction
	@FXML
	public void handleRec(ActionEvent event) {
		Stage currentStage = (Stage) Rec.getScene().getWindow();
	    currentStage.hide();
	    
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RecommendationForm.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	    @FXML
	    private Button ResetPass;

	    @FXML
	    void handleReset(ActionEvent event) {
	    	Stage currentStage = (Stage) Rec.getScene().getWindow();
		    currentStage.hide();
		    
			try {
		        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChangePasswordScene.fxml"));
		        Parent root1 = (Parent) fxmlLoader.load();
		        Stage stage = new Stage();
		        stage.setScene(new Scene(root1));  
		        stage.show();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
	    }


}
