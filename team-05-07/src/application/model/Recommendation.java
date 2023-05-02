package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Recommendation implements java.io.Serializable {
	String fileName;
	String firstName;
	String lastName;
	String gender;
	String school;
	LocalDate date;
	String program;
	String semester;
	String year;
	boolean isTermProjectDone;

	ArrayList<String> courses;
	ArrayList<String> grades;
	ArrayList<String> personalCharList;
	ArrayList<String> academicCharList;

	public Recommendation(String firstName, String lastName, LocalDate date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;

		courses = new ArrayList<>();
		grades = new ArrayList<>();
		personalCharList = new ArrayList<>();
		academicCharList = new ArrayList<>();
	}

	public boolean isTermProjectDone() {
		return isTermProjectDone;
	}

	public void setTermProjectDone(boolean isTermProjectDone) {
		this.isTermProjectDone = isTermProjectDone;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ArrayList<String> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}

	public ArrayList<String> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<String> grades) {
		this.grades = grades;
	}

	public void addCourse(String course) {
		courses.add(course);
	}

	public void addGrade(String grade) {
		grades.add(grade);
	}

	public void addPersonalChar(String personalChar) {
		personalCharList.add(personalChar);
	}

	public void addAcademicChar(String academicChar) {
		academicCharList.add(academicChar);
	}

	public ArrayList<String> getPersonalCharList() {
		return personalCharList;
	}

	public void setPersonalCharList(ArrayList<String> personalCharList) {
		this.personalCharList = personalCharList;
	}

	public ArrayList<String> getAcademicCharList() {
		return academicCharList;
	}

	public void setAcademicCharList(ArrayList<String> academicCharList) {
		this.academicCharList = academicCharList;
	}

}
