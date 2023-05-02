package application;

import application.file.ProfileObjectFile;
import application.model.Profile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ProfileController {

	@FXML
	private TextField sFull;

	@FXML
	private TextField sTitle;

	@FXML
	private TextField sSchool;

	@FXML
	private TextField sDep;

	@FXML
	private TextField sEmail;

	@FXML
	private TextField sPhone;

	@FXML
	private Button sSave;

	@FXML
	private Button sHomePage;

	@FXML
	void handleStaffSave(ActionEvent event) {
		System.out.println("Staff Save");

		String fullName = sFull.getText().trim();
		String title = sTitle.getText().trim();
		String staffSchool = sSchool.getText().trim();
		String department = sDep.getText().trim();
		String email = sEmail.getText().trim();
		String phone = sPhone.getText().trim();

		if (fullName.isEmpty()) {
			AlertUtil.showError("Must enter full name");
			return;
		}

		// pending other fields

		Profile p = new Profile(fullName, title, department, staffSchool, email, phone);

		System.out.println(fullName);
		System.out.println(title);
		System.out.println(staffSchool);
		System.out.println(department);
		System.out.println(email);
		System.out.println(phone);

		ProfileObjectFile.save(p);

	}

	@FXML
	void handleStaffHomePage(ActionEvent event) {
		Stage currentStage = (Stage) sHomePage.getScene().getWindow();
		currentStage.hide();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomeScene.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
