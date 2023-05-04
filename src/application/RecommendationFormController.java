/**
 * Sample Skeleton for 'RecommendationForm.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import application.file.LetterFile;
import application.file.ProfileObjectFile;
import application.file.RecommendationObjectFile;
import application.model.Profile;
import application.model.Recommendation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RecommendationFormController {

	private static String letterContent = "";

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML
	private TextField firstNameTF;

	@FXML
	private TextField lastNameTF;

	@FXML
	private TextField schoolTF;

	@FXML
	private DatePicker dateDP;

	@FXML
	private TextField yearTF;

	@FXML
	private HBox courseHBox;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="genderSelection"
	private ComboBox<String> genderSelection; // Value injected by FXMLLoader

	@FXML // fx:id="genderSelection"
	private ComboBox<String> programCB; // Value injected by FXMLLoader

	@FXML // fx:id="genderSelection"
	private ComboBox<String> semesterCB; // Value injected by FXMLLoader

//	@FXML // fx:id="genderSelection"
//	private ComboBox<String> Course1; // Value injected by FXMLLoader
//
//	@FXML // fx:id="genderSelection"
//	private ComboBox<String> Course2; // Value injected by FXMLLoader
//
//	@FXML // fx:id="genderSelection"
//	private ComboBox<String> Course3; // Value injected by FXMLLoader
//
//	@FXML // fx:id="genderSelection"
//	private ComboBox<String> Grade1; // Value injected by FXMLLoader
//
//	@FXML // fx:id="genderSelection"
//	private ComboBox<String> Grade2; // Value injected by FXMLLoader
//
//	@FXML // fx:id="genderSelection"
//	private ComboBox<String> Grade3; // Value injected by FXMLLoader

	@FXML // fx:id="listViewPC"
	private ListView<String> listViewPC; // Value injected by FXMLLoader

	private List<ComboBox<String>> courseComboList = new ArrayList<>();
	private List<ComboBox<String>> gradeComboList = new ArrayList<>();

	@FXML
	private Button recLogOut;

	@FXML
	private CheckBox termCheckBox;

	@FXML
	private Button homePageBtn;

	@FXML
	private Button compileBtn;

	@FXML // fx:id="selectionPC"
	private Label selectionPC; // Value injected by FXMLLoader

	@FXML // fx:id="listViewAC"
	private ListView<String> listViewAC; // Value injected by FXMLLoader

	@FXML // fx:id="selectionAC"
	private Label selectionAC; // Value injected by FXMLLoader

	private static Recommendation recommendationToModify;

	private static String mode;

	private List<String> courseNamesList = Arrays.asList("CS 151", "CS 149", "CS 49", "CS 163");

	private List<String> gradeNamesList = Arrays.asList("A", "B", "C", "D", "F");

	@FXML
	private VBox courseDynamicVBox;

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {

		genderSelection.setValue("");
		ObservableList<String> genderList = FXCollections.observableArrayList("Female", "Male");
		genderSelection.setItems(genderList);

		programCB.setValue("");
		ObservableList<String> programList = FXCollections.observableArrayList("Master of science (MS)",
				"Master of business administration (MBA)", "Doctor of philosophy (PhD)");
		programCB.setItems(programList);

		semesterCB.setValue("");
		ObservableList<String> semesterList = FXCollections.observableArrayList("Fall", "Spring", "Summer");
		semesterCB.setItems(semesterList);

		HBox rowHBox = createCourseRow();
		courseDynamicVBox.getChildren().add(rowHBox);

		listViewPC.setId("pC");
		listViewPC.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ObservableList<String> pC = FXCollections.observableArrayList("very passionate", "very enthusiastic",
				"punctual", "attentive", "polite");
		listViewPC.setItems(pC);

		listViewAC.setId("aC");
		listViewAC.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ObservableList<String> academicC = FXCollections.observableArrayList("submitted well-written assignments",
				"participated in all of my class activities", "worked hard",
				"was very well prepared for every exam and assignment", "picked up new skills quickly",
				"was able to excel academically at the top of my class");
		listViewAC.setItems(academicC);

		// assert genderSelection != null : "fx:id=\"genderSelection\" was not injected:
		// check your FXML file 'RecommendationForm.fxml'.";
		assert listViewPC != null
				: "fx:id=\"listViewPC\" was not injected: check your FXML file 'RecommendationForm.fxml'.";
		assert selectionPC != null
				: "fx:id=\"selectionPC\" was not injected: check your FXML file 'RecommendationForm.fxml'.";
		assert listViewAC != null
				: "fx:id=\"listViewAC\" was not injected: check your FXML file 'RecommendationForm.fxml'.";
		assert selectionAC != null
				: "fx:id=\"selectionAC\" was not injected: check your FXML file 'RecommendationForm.fxml'.";

		if (mode.equals("edit") && (recommendationToModify != null)) {
			setEditValues();
		}
	}

	private HBox createCourseRow() {
		HBox rowHBox = new HBox();
		ComboBox<String> courseCB;
		ComboBox<String> gradeCB;

		// create Course combo
		courseCB = new ComboBox<>();
		courseCB.setItems(FXCollections.observableArrayList(courseNamesList));
		courseComboList.add(courseCB);

		// create Grade combo
		gradeCB = new ComboBox<>();
		gradeCB.setItems(FXCollections.observableArrayList(gradeNamesList));
		gradeComboList.add(gradeCB);

		// add course nad grade Combo to row
		rowHBox.getChildren().addAll(courseCB, gradeCB);
		return rowHBox;
	}

	private void setEditValues() {
		firstNameTF.setText(recommendationToModify.getFirstName());
		lastNameTF.setText(recommendationToModify.getLastName());
		genderSelection.getSelectionModel().select(recommendationToModify.getGender());
		schoolTF.setText(recommendationToModify.getSchool());
		dateDP.setValue(recommendationToModify.getDate());
		programCB.getSelectionModel().select(recommendationToModify.getProgram());
		semesterCB.getSelectionModel().select(recommendationToModify.getSemester());
		yearTF.setText(recommendationToModify.getYear());

		if (recommendationToModify.isTermProjectDone()) {
			termCheckBox.setSelected(true);
		}

		// set course and grade values
		ArrayList<String> courseList = recommendationToModify.getCourses();
		ArrayList<String> gradeList = recommendationToModify.getGrades();

		for (int i = 0; i < courseList.size(); i++) {
			if (i > 0) {
				// create and add course combo rows, for 2nd course on wards.
				HBox rowHBox = createCourseRow();
				courseDynamicVBox.getChildren().add(rowHBox);
			}

			// set the course in combobox
			ComboBox<String> currentRowCourseComboBox = courseComboList.get(i);
			String courseName = courseList.get(i);
			currentRowCourseComboBox.getSelectionModel().select(courseName);
			// set the grade in combobox
			ComboBox<String> currentRowGradeComboBox = gradeComboList.get(i);
			String gradeName = gradeList.get(i);
			currentRowGradeComboBox.getSelectionModel().select(gradeName);
		} // for

		// set PC values
		ArrayList<String> pcList = recommendationToModify.getPersonalCharList();
		if (pcList.size() >= 1) {
			listViewPC.getSelectionModel().select(pcList.get(0));
		}
		if (pcList.size() >= 2) {
			listViewPC.getSelectionModel().select(pcList.get(1));
		}
		if (pcList.size() >= 3) {
			listViewPC.getSelectionModel().select(pcList.get(2));
		}

		// set AC values
		ArrayList<String> acList = recommendationToModify.getAcademicCharList();
		if (acList.size() >= 1) {
			listViewAC.getSelectionModel().select(acList.get(0));
		}
		if (acList.size() >= 2) {
			listViewAC.getSelectionModel().select(acList.get(1));
		}
		if (acList.size() >= 3) {
			listViewAC.getSelectionModel().select(acList.get(2));
		}

	}

	@FXML
	void handleAddCourse(ActionEvent event) {
		HBox rowHBox = createCourseRow();
		courseDynamicVBox.getChildren().add(rowHBox);
	}

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
		} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleCompile(ActionEvent event) {
		System.out.println("Compile");
		String firstName = firstNameTF.getText().trim();
		String lastName = lastNameTF.getText().trim();
		String gender = genderSelection.getValue();
		String school = schoolTF.getText().trim();
		LocalDate date = dateDP.getValue();
		String program = programCB.getValue();
		String semester = semesterCB.getValue();
		String year = yearTF.getText().trim();
		ObservableList<String> listPC = listViewPC.getSelectionModel().getSelectedItems();
		ObservableList<String> listAC = listViewAC.getSelectionModel().getSelectedItems();
		boolean isTermProjectDone = termCheckBox.isSelected();

		// validate
		if (firstName.isEmpty()) {
			AlertUtil.showError("You must enter First Name");
			return;
		}
		
		if (lastName.isEmpty()) {
			AlertUtil.showError("You must enter Last Name");
			return;
		}
		
		if (gender.isEmpty()) {
			AlertUtil.showError("You must student's gender");
			return;
		}
		
		if (school.isEmpty()) {
			AlertUtil.showError("You must enter school");
			return;
		}

		if (date == null) {
			AlertUtil.showError("You must select date");
			return;
		}
		
		if (program.isEmpty()) {
			AlertUtil.showError("You must enter program");
			return;
		}

		if (semester.isEmpty()) {
			AlertUtil.showError("You must enter semseter");
			return;
		}
		
		if (year.isEmpty()) {
			AlertUtil.showError("You must enter year");
			return;
		}
		
		if (listPC.isEmpty()) {
			AlertUtil.showError("You must select at least one personal chacteristic");
			return;
		}
		
		if (listAC.isEmpty()) {
			AlertUtil.showError("You must select at least one academic chacteristic");
			return;
		}
		// create Recommendation
		Recommendation rec = new Recommendation(firstName, lastName, date);
		rec.setGender(gender);
		rec.setSchool(school);
		rec.setProgram(program);
		rec.setSemester(semester);
		rec.setYear(year);
		rec.setTermProjectDone(isTermProjectDone);

		String firstCourse = null;

		// add Courses
		for (ComboBox<String> combo : courseComboList) {
			String courseName = combo.getSelectionModel().getSelectedItem();
			if (courseName != null) {
				rec.addCourse(courseName);
				if (firstCourse == null) {
					firstCourse = courseName;
				}
			}

		}

		if (firstCourse == null) {
			firstCourse = "";
		}

		String firstGrade = null;

		// add Grades
		for (ComboBox<String> combo : gradeComboList) {
			String gradeName = combo.getSelectionModel().getSelectedItem();
			if (gradeName != null) {
				rec.addGrade(gradeName);
				if (firstGrade == null) {
					firstGrade = gradeName;
				}
			}
		}

		if (firstGrade == null) {
			firstGrade = "";
		}

		String additionalCourseTemplate = null;
		if (rec.getCourses().size() > 1) {

			if (gender == "Male") {
				additionalCourseTemplate = LetterTemplate.COURSES_TEMPLATE_PREFIX.replace("<He/She>", "He");

			} else if (gender == "Female") {
				additionalCourseTemplate = LetterTemplate.COURSES_TEMPLATE_PREFIX.replace("<He/She>", "She");
				
			} else if (gender == "Female") {
				
				additionalCourseTemplate = LetterTemplate.COURSES_TEMPLATE_PREFIX.replace("<he/she>", "she");
			} else if (gender == "Male") {
				
				additionalCourseTemplate = LetterTemplate.COURSES_TEMPLATE_PREFIX.replace("<he/she>", "he");
			}

			ArrayList<String> courseList = rec.getCourses();
			ArrayList<String> gradeList = rec.getGrades();
			// start i from 1, so that first course is not added as additional
			for (int i = 1; i < courseList.size(); i++) {
				String repeatTemplate = LetterTemplate.COURSES_TEMPLATE_REPEAT.replace("<letter grade>",
						gradeList.get(i));
				repeatTemplate = repeatTemplate.replace("<course name>", courseList.get(i));
				if (i == courseList.size() - 1) {
					additionalCourseTemplate += " and ";
				} else {
					additionalCourseTemplate += ", ";
				}
				additionalCourseTemplate += repeatTemplate;
			}

			// add new line to more course template
			additionalCourseTemplate += "\n";
		}

		for (String pc : listPC) {
			rec.addPersonalChar(pc);
		}
		for (String ac : listAC) {
			rec.addAcademicChar(ac);
		}

		String valuesAC = "";
		for (int i = 0; i < listAC.size(); i++) {
			if (i == listAC.size() - 1) {
				valuesAC += " and ";
			} else {
				valuesAC += ", ";
			}
			valuesAC += listAC.get(i);
		}

		String valuesPC = "";
		for (int i = 0; i < listPC.size(); i++) {
			if (i == listPC.size() - 1) {
				valuesPC += " and ";
			} else {
				valuesPC += ", ";
			}
			valuesPC += listPC.get(i);
		}

		String template = LetterTemplate.TEMPLATE;
		template = template.replace("<Student's Full Name>", firstName + " " + lastName);
		template = template.replace("<Today's Date>", date.toString());
		template = template.replace("<program name>", program);
		template = template.replace("<Student's First Name>", firstName);
		template = template.replace("<First Semester>", semester);

		template = template.replace("<First Course Taken>", firstCourse);

		template = template.replace("<letter grade>", firstGrade);

		if (gender == "Male") {
			template = template.replace("<he/she>", "he");

		} else if (gender == "Female") {
			template = template.replace("<he/she>", "she");
		}

		if (gender == "Male") {
			template = template.replace("<He/She>", "He");

		} else if (gender == "Female") {
			template = template.replace("<He/She>", "She");
		}

		if (additionalCourseTemplate != null) {
			template = template.replace("<additional-course-info>", additionalCourseTemplate);
		} else {
			template = template.replace("<additional-course-info>", "\n");
		}
		
		if (gender == "Male") {
			template = template.replace("him", "him");

		} else if (gender == "Female") {
			template = template.replace("him", "her");
		}
			


		template = template.replace("<Coma separated Academic Characteristics>", valuesAC);
		template = template.replace("<Coma separated Personal Characteristics>", valuesPC);

		// term project
		String termTemplate = null;
		if (isTermProjectDone) {
			termTemplate = LetterTemplate.TERM_PROJECT_TEMPLATE;
			if (gender == "Male") {
				termTemplate = termTemplate.replace("<He/She>", "He");

			} else if (gender == "Female") {
				termTemplate = termTemplate.replace("<He/She>", "She");
				
			}else if (gender == "Male") {
				termTemplate = termTemplate.replace("<he/she>", "he");
				
			}else if (gender == "Female") {
				termTemplate = termTemplate.replace("<he/she>", "she");
				
			}
			// add new line to more course template
			termTemplate += "\n";
		}

		if (termTemplate != null) {
			template = template.replace("<term-project-info>", termTemplate);
		} else {
			template = template.replace("<term-project-info>", "\n");
		}
		
		
		
		
	


		// Read Profile from file
		Profile p = ProfileObjectFile.read();
//		if(p.equals(null)) {
//			AlertUtil.showError("Please fill out profile");
//		}

		String full = p.getFullName();
		String t = p.getTitle();
		String StaffSchool = p.getSchool();
		String dep = p.getDepartment();
		String email = p.getEmail();
		String phone = p.getPhone();
		System.out.println(full);

		if (full != null) {
			template = template.replace("<Professor's Full Name>", full);
		}
		if (t != null) {
			template = template.replace("<Professor's title>", t);
		}
		if (StaffSchool != null && dep != null) {
			template = template.replace("<School's name, department's name>", StaffSchool + ", " + dep);
		}
		if (email != null) {
			template = template.replace("<Professor's email address>", email);
		}
		if (phone != null) {
			template = template.replace("<Professor's phone number>", phone);
		}

		// Save LETTER
		String fileName = null;
		if (mode.equals("create")) {
			fileName = LetterFile.save(firstName, lastName, template, null);
		} else {
			fileName = LetterFile.save(firstName, lastName, template, recommendationToModify.getFileName());
		}

		// SAVE Recommendation
		rec.setFileName(fileName);
		RecommendationObjectFile.save(rec);

		// set object to modify
		CompiledTemController.setRecommendation(rec);

		// display form

		// Display letter content
		letterContent = template;

		displayLetterContent();
	}

	private void displayLetterContent() {
		Stage currentStage = (Stage) compileBtn.getScene().getWindow();
		currentStage.hide();

		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CompiledTem.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getLetterContent() {
		return letterContent;
	}

	public static void setRecommendation(Recommendation rec) {
		recommendationToModify = rec;
		setMode("edit");

	}

	public static void setMode(String createOrEdit) {
		mode = createOrEdit;

	}

}