package application.model;

import java.io.Serializable;

public class Profile implements Serializable {
	String fileName;
	String fullName;
	String title;
	String department;
	String school;
	String email;
	String phone;

	public Profile(String fullName, String title, String department, String school, String email, String phone) {
		this.fullName = fullName;
		this.title = title;
		this.department = department;
		this.school = school;
		this.email = email;
		this.phone = phone;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
