package com.faculty.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.faculty.dto.FacultyDto;
import com.faculty.dto.FacultyPostDto;
import com.faculty.entity.FacultyEntity;
import com.faculty.entity.FacultyPostEntity;
import com.faculty.entity.StudentInfo;
import com.faculty.exception.FacultyNotFoundException;
import com.faculty.exception.FacultyPostNotFoundException;
import com.faculty.repo.studentRepo;
import com.faculty.service.FacultyPostService;
import com.faculty.service.FacultyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@CrossOrigin("*")
@RestController
public class FacultyController {
	
	@Autowired 
	FacultyPostService facultypostservice;
	
	@Autowired 
	FacultyService facultyservice;
	
	@ApiOperation(value ="creates new  event")
	
	@ApiResponses(value= {
			@ApiResponse(code=201,message="New eventcreated"),
			@ApiResponse(code=404,message="No such event created"),
			@ApiResponse(code=400,message="Invalid event Inputs")
			
			
	})
	@PostMapping(value="/event",consumes=MediaType.ALL_VALUE)
    public void save(@RequestParam String facultyEmail,@RequestParam String eventname,
    		@RequestParam String description,@RequestParam(required=true) MultipartFile file)
    {
		System.out.println("facultyEmail"+facultyEmail);	
		System.out.println("eventname"+eventname);	
		 System.out.println("description"+description);	
		 System.out.println("file"+file);	
    }

	@PostMapping(value="/addevent",consumes=MediaType.ALL_VALUE)
    public void saveProduct(@RequestParam String facultyEmail,@RequestParam String eventname,
    		@RequestParam String description,@RequestParam(required=true,value="file") MultipartFile file) throws FacultyNotFoundException
    {
		 facultypostservice.postEvent(facultyEmail,eventname, description,file);	
    }
	
	
	@GetMapping(value="/viewevent")   
	public List<FacultyPostDto> getAllEvent() {	
				
		return facultypostservice.getAllEvent() ;							//returns All Elections
	}
	
	
	@GetMapping(value="/faculty/{facultyEmail}")   
	public FacultyEntity getAllfaculty(@PathVariable String facultyEmail)throws FacultyNotFoundException {	
					
		return facultyservice.getAllFaculty(facultyEmail) ;							//returns All Elections
	}
	
	
	@Transactional
	@DeleteMapping(value="/faculty/{eventId}/{facultyEmail}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FacultyPostEntity> deleteByEventId(@PathVariable int eventId,@PathVariable String facultyEmail)throws FacultyPostNotFoundException{		//Method To Delete Election By Id
		
		return facultypostservice.deleteByEventId(eventId,facultyEmail);
	
	}
	

	@GetMapping(value="/viewstudents")   
	public List<StudentInfo> getAllStudents() {	
				
		return facultyservice.getAllStudents() ;							//returns All Elections
	}
	
	
	@GetMapping(value="/FacultyLogin/{facultyEmail}/{password}")
	public Boolean authentication(@PathVariable("facultyEmail") String facultyEmail,@PathVariable("password") String password) 
	{
		return facultyservice.authentication(facultyEmail,password);
//		return "login successful";
	
	}
	
	

	@GetMapping(value="/facultypost/{facultyEmail}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FacultyPostEntity> view(@PathVariable String facultyEmail) throws FacultyNotFoundException{
		return facultyservice.view(facultyEmail);
	}
	
	
	
	
}
