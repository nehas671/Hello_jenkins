package com.faculty.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentInfo {

    @Id
	private int stId;
	private String stName;
	private String qualification;
	private String mailid;
	private String password;
	private int marks;
	private int backlogs;
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getBacklogs() {
		return backlogs;
	}
	public void setBacklogs(int backlogs) {
		this.backlogs = backlogs;
	}
	@Override
	public String toString() {
		return "StudentInfo [stId=" + stId + ", stName=" + stName + ", qualification=" + qualification + ", mailid="
				+ mailid + ", password=" + password + ", marks=" + marks + ", backlogs=" + backlogs + "]";
	}
	public StudentInfo(int stId, String stName, String qualification, String mailid, String password, int marks,
			int backlogs) {
		super();
		this.stId = stId;
		this.stName = stName;
		this.qualification = qualification;
		this.mailid = mailid;
		this.password = password;
		this.marks = marks;
		this.backlogs = backlogs;
	}
	public StudentInfo() {
	}
}