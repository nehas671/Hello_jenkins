package com.faculty.testController;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import javax.mail.Multipart;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.faculty.dto.FacultyDto;
import com.faculty.dto.FacultyPostDto;
import com.faculty.entity.FacultyEntity;
import com.faculty.entity.FacultyPostEntity;
import com.faculty.exception.FacultyNotFoundException;




public class FacultyControllerTest {

	private static Logger logger = LogManager.getLogger(FacultyControllerTest.class);
	
	@Test
	public void addElectionSuccess() {
		
		//logger.info("[START] addElectionSuccess()");
		
		RestTemplate restTemplate = new RestTemplate();
//		URI uri = null;
//		try {
//			uri = new URI("gototop.png");
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	//	final InputStream reader = getClass().getResourceAsStream("gototop.png");
		
		String file = "gototop.png";
	//	file.getBytes()
		logger.info("hello world!");
		logger.error("reader: "+ file.getBytes());
		
		
		
		
	       
	      
	     MockMultipartFile img = new MockMultipartFile("file",file.getBytes());
	     
		FacultyPostDto facultypost = new FacultyPostDto("Annual Gathering","Cultural Gathering 2021",img.toString(), "meetalipatidar@gmail.com");
		//HttpHeaders headers=new HttpHeaders();
	    // headers.set("multipart/form-data","Student added successfully");
	    // HttpEntity<FacultyPostDto> request=new HttpEntity<>(facultypost, headers);
		ResponseEntity<FacultyPostDto> responseEntityElection= restTemplate.postForEntity("http://localhost:8081/addevent",facultypost, FacultyPostDto.class);
		//restTemplate.postForObject("http://localhost:8081/addevent", FacultyPostDto.class,facultypost.getFacultyEmail(),facultypost.getEventname(),facultypost.getDescription(),facultypost.getImage());    
		//Assert.assertEquals(200, result.getStatusCodeValue());
	       // Assert.assertNotNull(info);
		
		//FacultyPostDto responseEntityElection = restTemplate. postForObject("http://localhost:8081/addevent", facultypost.getEventname(), facultypost.getDescription());
		assertNotNull(facultypost);
		
		//logger.info("[END] addElectionSuccess()");
		
	}
	
	/*------------------Test case for Viewing All Elections By State--[Pass]--------------*/
	@Test
	void testgetFacultyByEmail() {
		logger.info(" [START]  testgetFacultyByEmail");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<FacultyEntity> responseEntity = restTemplate.getForEntity("http://localhost:8081/faculty/nehasunilsahu168@gmail.com",FacultyEntity.class);
		logger.info(responseEntity);
		assertNotNull(responseEntity);
		
		logger.info("[END] testgetFacultyByEmail");
		
	}
	
	
	
	@Test
	void testgetFacultyByEmail_FacultyNotFound() {
		logger.info(" [START] testgetFacultyByEmail_FacultyNotFound()");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.NotFound.class,
				()->{
					
					 restTemplate.getForEntity("http://localhost:8081/faculty/meetalipatidar@gmail.com",FacultyEntity.class);	
				}
				);
		 logger.error(exception.getMessage());
		 logger.info("[END] testgetFacultyByEmail_FacultyNotFound()");
	}
	
	
	/*------------------Test case for Viewing All Elections By State--[Pass]--------------*/
	@Test
	void testgetevent() {
		logger.info(" [START]  testgetevent");
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<FacultyPostEntity[]> responseEntity = restTemplate.getForEntity("http://localhost:8081/viewevent",FacultyPostEntity[].class);
		logger.info(responseEntity);
		assertNotNull(responseEntity);
		
		logger.info("[END] testgetevent");
		
	}
	
	/*-------------------------Test Case for Deleting Election------------------*/
	 
//	@Test
//	void testDeleteEventById() {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.delete("http://localhost:8081/faculty/{eventId}",40);
//	}
//	
	
	
	@Test
	void testDeleteEventById_EventNotFound() {
		logger.info(" [START] testDeleteEventById_EventNotFound()");
		RestTemplate restTemplate = new RestTemplate();
		Exception exception = assertThrows(org.springframework.web.client.HttpClientErrorException.NotFound.class,
				()->{
					
					 restTemplate.delete("http://localhost:8081/faculty/{eventId}",40);	
				}
				);
		 logger.error(exception.getMessage());
		 logger.info("[END] testDeleteEventById_EventNotFound()");
	}
	
	
	
	
	
}
