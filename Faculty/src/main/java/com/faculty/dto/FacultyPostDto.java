package com.faculty.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class FacultyPostDto {

	private int eventId;
	
	@NotNull
	@NotBlank
	@Pattern(regexp = "[a-zA-Z][a-zA-Z ]{3,}")
	private String eventname;
	
	@NotNull
	@NotBlank
	@Pattern(regexp = "[a-zA-Z][a-zA-Z ]")
	private String description;
	private String image;
	
	@NotBlank(message="Email_Id is mandatory!!")
	@Email
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z]+.[a-zA-A]+",message = "enter email in valid format")
	private String facultyEmail;
	
	
	
	
	
	public String getFacultyEmail() {
		return facultyEmail;
	}
	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String bs) {
		this.image = bs;
	}
	public FacultyPostDto(int eventId, String eventname, String description, String image) {
		super();
		this.eventId = eventId;
		this.eventname = eventname;
		this.description = description;
		this.image = image;
	}
	
	
	public FacultyPostDto(String eventname, String description, String image, String facultyEmail) {
		super();
		this.eventname = eventname;
		this.description = description;
		this.image = image;
		this.facultyEmail = facultyEmail;
	}
	public FacultyPostDto(int eventId, String eventname, String description, String image, String facultyEmail) {
		super();
		this.eventId = eventId;
		this.eventname = eventname;
		this.description = description;
		this.image = image;
		this.facultyEmail = facultyEmail;
	}
	public FacultyPostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FacultyPostDto(String eventname2, String description2, String image2) {
		super();
		this.eventname = eventname2;
		this.description = description2;
		this.image = image2;
	}
	@Override
	public String toString() {
		return "FacultyPostDto [eventId=" + eventId + ", eventname=" + eventname + ", description=" + description
				+ ", image=" + image + ", facultyEmail=" + facultyEmail + "]";
	}
	
	
}
