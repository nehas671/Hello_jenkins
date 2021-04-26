package com.faculty.dto;

import org.springframework.stereotype.Component;


public class FacultyDto {

	private int facultyId;
	private String facultyName;
	private String password;
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "FacultyDto [facultyId=" + facultyId + ", facultyName=" + facultyName + ", password=" + password + "]";
	}
	public FacultyDto(int facultyId, String facultyName, String password) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.password = password;
	}
	public FacultyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
