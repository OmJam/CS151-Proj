package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;

public class LoginSceneController {
	
	@FXML
	private Button loginBtn;
	
	@FXML
	private TextField uname, pass;

	// Event Listener on Button.onAction
	@FXML
	public void handleLogin(ActionEvent event) {
		
		// String userName = uname.getText();
		String password = pass.getText();
		
		if(password.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please fill all the fields!");
			alert.showAndWait();
			return;
		}
		
		
		
		
	    
	    String scene = "ChangePasswordScene.fxml";
		String passToCheck = alreadyExist(password);
		
		if(!passToCheck.equals("")) {
			if(passToCheck.equals(password))
				scene = "HomeScene.fxml";
			else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Invalid Password!");
				alert.showAndWait();
				return;
			}
		}
		else {
			
			if(!password.equals("p")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Invalid default password!");
				alert.showAndWait();
				return;
			}
			
			saveData(password);
			
		}
		
		Stage currentStage = (Stage) loginBtn.getScene().getWindow();
	    currentStage.hide();

		try {
			
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(scene));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root1));  
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	// Event Listener on Button.onAction
	@FXML
	public void handleExit(ActionEvent event) {
		System.exit(0); // exit application
	}
	
	// Saving credentials to text file
	public void saveData(String password) {
		try {
		     FileWriter myWriter = new FileWriter("data.txt");
		     myWriter.write(password);
		     myWriter.close();
		} catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	// check whether username is already saved
	public String alreadyExist(String username) {
		try {
			Scanner in = new Scanner(new File("data.txt"));
		    String line = in.nextLine();
		    String savedUsername = line.split(",")[0]; // get username
		    if(savedUsername.equals(username)) {
		    	return line.split(",")[0]; // return password
		    }
		    else {
		    	return "";
		    }
		} catch (Exception e) {
			 return "";
		}
	}
}
