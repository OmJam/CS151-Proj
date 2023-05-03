/**
 * Sample Skeleton for 'RecommendationForm.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class RecommendationFormController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="genderSelection"
    private ComboBox<String> genderSelection; // Value injected by FXMLLoader
    	
    @FXML // fx:id="genderSelection"
    private ComboBox<String> Program; // Value injected by FXMLLoader
    	
    @FXML // fx:id="genderSelection"
    private ComboBox<String> Semester; // Value injected by FXMLLoader
    
    @FXML // fx:id="genderSelection"
    private ComboBox<String> Course1; // Value injected by FXMLLoader
    
    @FXML // fx:id="genderSelection"
    private ComboBox<String> Course2; // Value injected by FXMLLoader
    
    @FXML // fx:id="genderSelection"
    private ComboBox<String> Course3; // Value injected by FXMLLoader
    
    @FXML // fx:id="genderSelection"
    private ComboBox<String> Grade1; // Value injected by FXMLLoader
    
    @FXML // fx:id="genderSelection"
    private ComboBox<String> Grade2; // Value injected by FXMLLoader

    @FXML // fx:id="genderSelection"
    private ComboBox<String> Grade3; // Value injected by FXMLLoader
    
    @FXML // fx:id="listViewPC"
    private ListView<String> listViewPC; // Value injected by FXMLLoader
    
    @FXML
	private Button recLogOut;
    
    @FXML
	private Button homePageBtn;

    	
    	
    @FXML // fx:id="selectionPC"
    private Label selectionPC; // Value injected by FXMLLoader

    @FXML // fx:id="listViewAC"
    private ListView<String> listViewAC; // Value injected by FXMLLoader

    @FXML // fx:id="selectionAC"
    private Label selectionAC; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	
    	genderSelection.setValue("Gender");
    	ObservableList<String> genderList = FXCollections.observableArrayList(
               "Female", "Male");
    	genderSelection.setItems(genderList);
    	
    	Program.setValue("Program");
    	ObservableList<String> programList = FXCollections.observableArrayList(
               "Bachelors", "Masters", "Ph.D");
    	Program.setItems(programList);
    	
    	Semester.setValue("Semester");
    	ObservableList<String> semesterList = FXCollections.observableArrayList(
               "Fall", "Spring");
    	Semester.setItems(semesterList);
    	
    	Course1.setValue("Course");
    	ObservableList<String> course1List = FXCollections.observableArrayList(
              "CS 151", "CS 149", "CS 49", "CS 163");
    	Course1.setItems(course1List);
    	
    	Course2.setValue("Course ");
    	ObservableList<String> course2List = FXCollections.observableArrayList(
                "CS 151", "CS 149", "CS 49", "CS 163");
    	Course2.setItems(course2List);
    	
    	Course3.setValue("Course ");
    	ObservableList<String> course3List = FXCollections.observableArrayList(
                "CS 151", "CS 149", "CS 49", "CS 163");
    	Course3.setItems(course3List);
    	
    	Grade1.setValue("Grade 1");
    	ObservableList<String> grade1List = FXCollections.observableArrayList(
               "A", "B", "C", "D", "F");
    	Grade1.setItems(grade1List);
    	
    	Grade2.setValue("Grade 2");
    	ObservableList<String> gradeList2 = FXCollections.observableArrayList(
               "A", "B", "C", "D", "F");
    	Grade2.setItems(gradeList2);
    	
    	Grade3.setValue("Grade 2");
    	ObservableList<String> gradeList3 = FXCollections.observableArrayList(
               "A", "B", "C", "D", "F");
    	Grade3.setItems(gradeList3);
    	
    	listViewPC.setId("pC");
    	listViewPC.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	ObservableList<String> pC = FXCollections.observableArrayList(
               "Academic", "Happy", "Excited");
    	listViewPC.setItems(pC);

    	
    	listViewAC.setId("aC");
    	listViewAC.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	ObservableList<String> academicC = FXCollections.observableArrayList(
               "Studious", "Independent", "Top");
    	listViewAC.setItems(academicC);
    	

        //assert genderSelection != null : "fx:id=\"genderSelection\" was not injected: check your FXML file 'RecommendationForm.fxml'.";
        assert listViewPC != null : "fx:id=\"listViewPC\" was not injected: check your FXML file 'RecommendationForm.fxml'.";
        assert selectionPC != null : "fx:id=\"selectionPC\" was not injected: check your FXML file 'RecommendationForm.fxml'.";
        assert listViewAC != null : "fx:id=\"listViewAC\" was not injected: check your FXML file 'RecommendationForm.fxml'.";
        assert selectionAC != null : "fx:id=\"selectionAC\" was not injected: check your FXML file 'RecommendationForm.fxml'.";}
        
        
        
        @FXML
        void handleRecLogOut(ActionEvent event) {
        	Stage currentStage = (Stage) recLogOut.getScene().getWindow();
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
        void handleHomePage(ActionEvent event) {
        	Stage currentStage = (Stage) homePageBtn.getScene().getWindow();
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

    
}