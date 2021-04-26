package com.faculty.util;

import java.util.ArrayList;
import java.util.List;


import com.faculty.dto.FacultyPostDto;
import com.faculty.entity.FacultyPostEntity;



public class FacultyUtil {

	
	public static FacultyPostEntity convertFacultytoFacultyEntity(FacultyPostDto faculty)
	{
		return new FacultyPostEntity(faculty.getEventId(),faculty.getEventname(),faculty.getDescription(),faculty.getFacultyEmail(),faculty.getImage());
	}
	
	public static FacultyPostDto convertFacultyEntitytoFaculty(FacultyPostEntity facultyentity)
	{
		System.out.println("inside convert:"+facultyentity);
		return new FacultyPostDto(facultyentity.getEventId(),facultyentity.getEventname(),facultyentity.getDescription(),facultyentity.getImage(),facultyentity.getFacultyEmail());
	}

	public static List<FacultyPostDto> convertFacultyentityListtoFacultyList(List<FacultyPostEntity> facultyentity) {
		// TODO Auto-generated method stub
		List<FacultyPostDto> faculty = new ArrayList<FacultyPostDto>();
		System.out.println("inside util"+facultyentity);
		for(FacultyPostEntity facultyEntity: facultyentity) {
			
			System.out.println("inside util before convert"+facultyEntity);
			System.out.println(convertFacultyEntitytoFaculty(facultyEntity));
			faculty.add(convertFacultyEntitytoFaculty(facultyEntity));
			System.out.println("inside util loop"+faculty);
		}
		
		return faculty;
	}
	
	
	
}
