package application;

import java.util.ArrayList;
import java.util.List;

import application.file.LetterFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeSceneController {

	@FXML
	private Button logoutBtn;

	@FXML
	private Button Rec;

	@FXML
	private Button ResetPass;

	@FXML
	private Button searchBtn;
	
	@FXML
	private TextField searchTF;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Event Listener on Button.onAction
	@FXML
	public void handleRec(ActionEvent event) {
		Stage currentStage = (Stage) Rec.getScene().getWindow();
		currentStage.hide();

		try {
			RecommendationFormController.setMode("create");
			
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
	void handleReset(ActionEvent event) {
		Stage currentStage = (Stage) Rec.getScene().getWindow();
		currentStage.hide();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChangePasswordScene.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private Button profileBtn;

	@FXML
	void handleProfileSettings(ActionEvent event) {
		Stage currentStage = (Stage) Rec.getScene().getWindow();
		currentStage.hide();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Profile.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleSearch(ActionEvent event) {

		List<String> list = LetterFile.getFileNamesList();
		if (list == null || list.isEmpty()) {
			AlertUtil.showInfo("No matching results found.");
			return;
		}

		String entry = searchTF.getText().toUpperCase();
		System.out.println("Entered Search: " + entry);
		List<String> matchedList = new ArrayList<>();
		for (String filePath : list) {
			if (filePath.toUpperCase().contains("-" + entry + "-")) {
				String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
				matchedList.add(fileName);
			}
		}

		if (matchedList.isEmpty()) {
			AlertUtil.showInfo("No matching results found.");
			return;
		}

		SearchResultController.setFileNamesList(matchedList);

		Stage currentStage = (Stage) Rec.getScene().getWindow();
		currentStage.hide();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SearchResult.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
