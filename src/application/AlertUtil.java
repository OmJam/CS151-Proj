package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class AlertUtil {

	public static void showInfo(String message) {
		Alert alert = new Alert(AlertType.INFORMATION, message, ButtonType.OK);
		alert.showAndWait();
	}

	public static void showError(String message) {
		Alert alert = new Alert(AlertType.ERROR, message, ButtonType.OK);
		alert.showAndWait();
	}

}
