package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.file.LetterFile;
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

	@FXML
	public void handleSaveNewEdit(ActionEvent event) {
		AlertUtil.showInfo("Text has been saved in a seperate file");
		String TA = letterTA.getText();
		String result[] = TA.split("\n");
		
		System.out.print("result = ");
	    for (String str : result) {
	      System.out.println(str + ", ");
	    }
	    String firstLastLine = null;
	    firstLastLine = result[1];
	    String substr = firstLastLine.substring(5);
	    System.out.println(substr);
	    int space = 0;
	    for(int i = 0; i < substr.length(); i++) {
	    	char c = substr.charAt(i);
	    	if(Character.isWhitespace(c)){
	    		space = i;
	    		break;
	    	}
	    	
	    }
	    String firstName = substr.substring(0, space);
	    String lastName = substr.substring(space +1, substr.length());
	    System.out.println(firstName);
	    System.out.println(lastName);
	    
	    LetterFile newLetterTA = new LetterFile();
	    
	   
	    newLetterTA.save(firstName, lastName, TA,  newLetterTA.getFileName(firstName, lastName));
	    
	    
	   
		
		
		
//		System.out.println(letterTA.getText());
//		Pattern pattern = Pattern.compile("For: ");
//		Matcher matcher = pattern.matcher("Found first and last");
//		boolean matchFound = matcher.find();
//	    if(matchFound) {
//	    	String fName = null;
//	    	String lName = null;
//	    	
//	      System.out.println("Match found");
//	    } else {
//	      System.out.println("Cannot find first and last");
//	    }
	}
		
}
