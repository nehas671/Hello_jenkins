package com.faculty.testService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.faculty.dto.FacultyPostDto;
import com.faculty.entity.FacultyEntity;
import com.faculty.entity.FacultyPostEntity;
import com.faculty.exception.FacultyNotFoundException;
import com.faculty.exception.FacultyPostNotFoundException;
import com.faculty.service.FacultyPostService;
import com.faculty.service.FacultyService;
import com.faculty.testController.FacultyControllerTest;

@SpringBootTest
public class FacultyPostServiceTest {

	private static Logger logger = LogManager.getLogger(FacultyPostServiceTest.class);
	
	@Autowired
	private FacultyService facultyservice;
	
	@Autowired
	private FacultyPostService facultypostservice;
	
	
	@Test
	public void testPostAdvertisement() throws  IOException, FacultyNotFoundException {
		logger.info(" [START] testPostAdvertisement");
		MultipartFile file = null;
		FileInputStream input = new FileInputStream("C:/Users/NEHA/Pictures/gototop.png");
		logger.error("iiinnnnnnnnnnnnnnn:" +input);
		// file = new MockMultipartFile("file", file.getName(), "image/jpg", input.readAllBytes());
		 file = new MockMultipartFile("file","C:/Users/NEHA/Pictures/gototop.png", MediaType.ALL_VALUE, input);
		logger.error("sssssssssssssssssssssss " +file);
		facultypostservice.postEvent("nehasunilsahu168@gmail.com","dj party","dj vale babu mera gana chala do", file);
		logger.info("[END] testPostAdvertisement");
	}
	
	
	
	
	
	@Test
	void testgetFacultyByEmail() throws FacultyNotFoundException {
		logger.info(" [START] testgetFacultyByEmail");
		//RestTemplate restTemplate = new RestTemplate();
		
			FacultyEntity savedUser =facultyservice.getAllFaculty("nehasunilsahu168@gmail.com");
			assertThat(savedUser).isNotNull();
		 logger.info("[END] testgetFacultyByEmail");
	}
	
	
	@Test
	void testgetFacultyByEmail_FacultyNotFound() {
		logger.info(" [START] testgetFacultyByEmail_FacultyNotFound()");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(com.faculty.exception.FacultyNotFoundException.class,
				()->{
					
					facultyservice.getAllFaculty("meetalipatidar@gmail.com");
				}
				);
		 logger.error(exception.getMessage());
		 logger.info("[END] testgetFacultyByEmail_FacultyNotFound()");
	}
	
	@Test
	void testgetevent() {
		logger.info(" [START]  testgetevent");
		
		RestTemplate restTemplate = new RestTemplate();

		List<FacultyPostDto> savedUser =facultypostservice.getAllEvent();
		assertThat(savedUser).isNotNull();
		logger.info("[END] testgetevent");
		
	}
	
	
	@Test
	void testdeleteevent() throws FacultyPostNotFoundException {
		logger.info(" [START]  testdeletevent");
		
		RestTemplate restTemplate = new RestTemplate();

		List<FacultyPostEntity> savedUser =facultypostservice.deleteByEventId(39,"sfdgfhg");
		assertThat(savedUser).isNotNull();
		logger.info("[END] testdeleteevent");
		
	}
	
	
	@Test
	void testDeleteEventById_EventNotFound() {
		logger.info(" [START] testDeleteEventById_EventNotFound()");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(com.faculty.exception.FacultyPostNotFoundException.class,
				()->{
					
					facultypostservice.deleteByEventId(39,"asdfh");
					
				}
				);
		 logger.error(exception.getMessage());
		 logger.info("[END] testDeleteEventById_EventNotFound()");
	}
	
}


