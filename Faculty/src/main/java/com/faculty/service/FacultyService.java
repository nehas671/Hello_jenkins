package com.faculty.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.faculty.dto.FacultyDto;
import com.faculty.dto.FacultyPostDto;
import com.faculty.entity.FacultyEntity;
import com.faculty.entity.FacultyPostEntity;
import com.faculty.entity.StudentInfo;
import com.faculty.exception.FacultyNotFoundException;

public interface FacultyService {

	
	FacultyEntity getAllFaculty(String facultyEmail) throws FacultyNotFoundException;

	List<StudentInfo> getAllStudents();

	Boolean authentication(String mailid, String password);

	List<FacultyPostEntity> view(String facultyEmail) throws FacultyNotFoundException;

	

}
