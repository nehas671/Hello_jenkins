package com.faculty.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.faculty.dto.FacultyPostDto;
import com.faculty.entity.FacultyPostEntity;
import com.faculty.exception.FacultyNotFoundException;
import com.faculty.exception.FacultyPostNotFoundException;

public interface FacultyPostService {

	
	void postEvent(String facultyEmail,String eventName, String description, MultipartFile file) throws FacultyNotFoundException;

	List<FacultyPostDto> getAllEvent();

	List<FacultyPostEntity> deleteByEventId(int id,String facultyEmail) throws FacultyPostNotFoundException;
}
