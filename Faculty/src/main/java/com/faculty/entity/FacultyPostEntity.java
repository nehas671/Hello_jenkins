package com.faculty.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;


@Entity
public class FacultyPostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventId;
	private String eventname;
	private String description;
	private String facultyEmail;
	
	//@Type(type="org.hibernate.type.BinaryType")
	@Lob
	private String image;
	
	
	public int getEventId() {
		return eventId;
	}
	public FacultyPostEntity(int eventId, String eventname, String description, String facultyEmail, String image) {
		super();
		this.eventId = eventId;
		this.eventname = eventname;
		this.description = description;
		this.facultyEmail = facultyEmail;
		this.image = image;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getFacultyEmail() {
		return facultyEmail;
	}
	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
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
	public void setImage(String image) {
		this.image = image;
	}
	public FacultyPostEntity(int eventId, String eventname, String description,String image) {
		super();
		this.eventId = eventId;
		this.eventname = eventname;
		this.description = description;
		this.image = image;
	}
	
	
	public FacultyPostEntity(String eventname, String description, String image) {
		super();
		this.eventname = eventname;
		this.description = description;
		this.image = image;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public FacultyPostEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FacultyPostEntity [facultyId=" + eventId + ", eventname=" + eventname + ", description=" + description
				+ ", image=" + image + "]";
	}
	
	
}
