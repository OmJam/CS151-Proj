package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;

public class ChangePasswordSceneController {
	
	@FXML
	private Button backBtn;

	@FXML
	private TextField oldPass, newPass, confirmPass;
	
	// Event Listener on Button.onAction
	@FXML
	public void handleResetPassword(ActionEvent event) {
		
		String pass1 = oldPass.getText();
		String pass2 = newPass.getText();
		String pass3 = confirmPass.getText();
		
		if(pass1.equals("") || pass2.equals("") || pass3.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Please fill all the fields!");
			alert.showAndWait();
			return;
		}
		
		if(!pass2.equals(pass3)) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("New and confirm passwords are not same!");
			alert.showAndWait();
			return;
		}
		
		if(updateData(pass1, pass2)) { // if passwrord is changed
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Password changed successfully!");
			alert.showAndWait();
			
			Stage currentStage = (Stage) backBtn.getScene().getWindow();
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
		else { // in case of wrong old password
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("Old password is incorrect!");
			alert.showAndWait();
			return;
		}
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void handleBack(ActionEvent event) {
		Stage currentStage = (Stage) backBtn.getScene().getWindow();
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
	
	
	public boolean updateData(String pass1, String pass2) {
		String savedUsername = "";
		
		try {
		     Scanner in = new Scanner(new File("data.txt"));
		     String line = in.nextLine();
		     savedUsername = line.split(",")[0]; // get username
		     
		     if(!pass1.equals(line.split(",")[0])) { // If old password is incorrect, return false
		    	 return false;
		     }
		     
		} catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return false;
		}
		
		try {
		     FileWriter myWriter = new FileWriter("data.txt");
		     myWriter.write(pass2);
		     myWriter.close();
		     return true;
		} catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return false;
		}
	}
}
