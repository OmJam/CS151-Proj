package application;

import application.model.Recommendation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class CompiledTemController {

	private static Recommendation currentRecommendation;

	@FXML
	private TextArea letterTA;

	@FXML
	private Button CompEditBtn;
	
	@FXML
	private Button cHomeBtn;
	
	@FXML
	private Button saveNewEdit;

	@FXML
	void initialize() {
		String content = RecommendationFormController.getLetterContent();
		letterTA.setText(content);
	}

	@FXML
	void handleEdit(ActionEvent event) {
		// set object to modify
		RecommendationFormController.setRecommendation(currentRecommendation);

		// display form

		Stage currentStage = (Stage) CompEditBtn.getScene().getWindow();
		currentStage.hide();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RecommendationForm.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@FXML
    void handleCHome(ActionEvent event) {
    	Stage currentStage = (Stage) cHomeBtn.getScene().getWindow();
	    currentStage.hide();
	    
		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomeScene.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
    	
    }

	public static void setRecommendation(Recommendation rec) {
		currentRecommendation = rec;
	}
	
	@FXML
	public void handleCTExit(ActionEvent event) {
		System.exit(0); // exit application
	}

	
	public void handleSaveNewEdit(ActionEvent event) {
		
	}
}
