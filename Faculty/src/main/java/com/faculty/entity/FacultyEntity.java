package com.faculty.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;


@Entity
public class FacultyEntity {

	@Id
	private String facultyEmail;
	private String facultyName;
	private String password;
	
	@OneToMany
    @JoinColumn(name="facultyEmail")
    private List<FacultyPostEntity> postlist=new ArrayList();
	
	
	
	public List<FacultyPostEntity> getPostlist() {
		return postlist;
	}
	public void setPostlist(List<FacultyPostEntity> postlist) {
		this.postlist = postlist;
	}
	
	public String getFacultyEmail() {
		return facultyEmail;
	}
	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
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
	
	
	public FacultyEntity(String facultyEmail, String facultyName, String password) {
		super();
		this.facultyEmail = facultyEmail;
		this.facultyName = facultyName;
		this.password = password;
	}
	public FacultyEntity(String facultyEmail, String facultyName, String password, List<FacultyPostEntity> postlist) {
		super();
		this.facultyEmail = facultyEmail;
		this.facultyName = facultyName;
		this.password = password;
		this.postlist = postlist;
	}
	public FacultyEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FacultyEntity [facultyEmail=" + facultyEmail + ", facultyName=" + facultyName + ", password=" + password
				+ ", postlist=" + postlist + "]";
	}
	
	
	
	
}
