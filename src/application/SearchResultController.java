package application;

import java.util.List;

import application.file.LetterFile;
import application.file.RecommendationObjectFile;
import application.model.Recommendation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class SearchResultController {

	@FXML
	private ListView<String> letterLV;

	@FXML
	private Button editBtn;
	@FXML
	private Button deleteBtn;
	@FXML
	private Button srHomeBtn;

	private static List<String> fileNamesList;

	@FXML
	void initialize() {
		if (fileNamesList == null || fileNamesList.isEmpty()) {
			AlertUtil.showInfo("No matching results found.");
			return;
		}
		//clear old values
		letterLV.getItems().clear();

		//add new values
		ObservableList<String> list = FXCollections.observableArrayList(fileNamesList);
		letterLV.setItems(list);

		letterLV.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

	@FXML
	void handleEdit(ActionEvent event) {
		String fileName = letterLV.getSelectionModel().getSelectedItem();
		if (fileName == null) {
			AlertUtil.showError("You must select an item.");
			return;
		}
		//read object from file
		Recommendation rec = RecommendationObjectFile.read(fileName);
		//set object to modify
		RecommendationFormController.setRecommendation(rec);
		
		//display form
		Stage currentStage = (Stage) editBtn.getScene().getWindow();
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
	void handleDelete(ActionEvent event) {
		String fileName = letterLV.getSelectionModel().getSelectedItem();
		if (fileName == null) {
			AlertUtil.showError("You must select an item.");
			return;
		}

		boolean success = LetterFile.deleteFile(fileName);
		if (success) {
			AlertUtil.showInfo("Deleted file: " + fileName);
			ObservableList<String> items = letterLV.getItems();
			for (int i = 0; i < items.size(); i++) {
				String item = items.get(i);
				if (item.equals(fileName)) {
					items.remove(i);
				}
			}
		} else {
			AlertUtil.showError("Could not delete file: " + fileName);
		}

	}
	
	@FXML
    void handleSRHome(ActionEvent event) {
    	Stage currentStage = (Stage) srHomeBtn.getScene().getWindow();
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

	public static void setFileNamesList(List<String> list) {
		fileNamesList = list;
	}

}
