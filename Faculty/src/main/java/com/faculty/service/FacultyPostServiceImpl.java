package com.faculty.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.faculty.dto.FacultyPostDto;
import com.faculty.entity.FacultyEntity;
import com.faculty.entity.FacultyPostEntity;
import com.faculty.entity.StudentInfo;
import com.faculty.exception.FacultyNotFoundException;
import com.faculty.exception.FacultyPostNotFoundException;
import com.faculty.repo.FacultyPostRepo;
import com.faculty.repo.FacultyRepo;
import com.faculty.repo.studentRepo;
import com.faculty.util.FacultyUtil;



@Service
public class FacultyPostServiceImpl implements FacultyPostService{

	 @Autowired
	 private JavaMailSender javaMailSender;
	
	@Autowired
	private FacultyPostDto faculty;
	
	@Autowired
	private FacultyPostRepo facultypostrepo;
	
	@Autowired
	private FacultyRepo facultyrepo;
	
	@Autowired
	private studentRepo studentrepo;
	
	@Transactional
	@Override
	public void postEvent(String facultyEmail,String eventName, String description, MultipartFile file) throws FacultyNotFoundException {
		
		//FacultyDto faculty = new FacultyDto();
		FacultyEntity fac = facultyrepo.findByFacultyEmail(facultyEmail);
		if(fac!=null)
		{
		
		 List<StudentInfo> students = studentrepo.findAll();
		
		 
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			faculty.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		faculty.setDescription(description);
		
        faculty.setEventname(eventName);
        faculty.setFacultyEmail(facultyEmail);
        
        FacultyPostEntity facultyentity = FacultyUtil.convertFacultytoFacultyEntity(faculty);
       
        facultypostrepo.save(facultyentity);
        
        List<String> email = new ArrayList<>();
        for(StudentInfo s : students)
        {
        	email.add(s.getMailid());
        }
        
        
        SimpleMailMessage msg = new SimpleMailMessage();
        System.out.println(email);
        email.forEach(mail->{msg.setTo(mail);
        		 msg.setSubject(eventName+"Posted By "+fac.getFacultyName());
        msg.setText(description);

        javaMailSender.send(msg);});
        
		}
		else
		{
			throw new FacultyNotFoundException("faculty does not exist");
		}
	}

	
	    
	@Override
	public List<FacultyPostDto> getAllEvent() {
		List<FacultyPostEntity> facultyentity = (List<FacultyPostEntity>) facultypostrepo.findAll();
		
		return FacultyUtil.convertFacultyentityListtoFacultyList(facultyentity);
	}
	
	

	@Override
	public List<FacultyPostEntity> deleteByEventId(int id,String facultyEmail)throws FacultyPostNotFoundException {					//Method To delete Election By Id
		// TODO Auto-generated method stub
				
				Optional<FacultyPostEntity> opFacultyPostEntity =  facultypostrepo.findById(id);
				
				if(opFacultyPostEntity.isPresent())
				{
					
					facultypostrepo.deleteById(id);
					
								//Return true id Election Deleted
					
				}else {
					throw new FacultyPostNotFoundException("PostId : " + id);
				}
				
				List< FacultyPostEntity> e = facultypostrepo.findByFacultyEmail(facultyEmail);
				 if(e.isEmpty())
				 {
					 return null;
				 }else {
					 
					 return e;
				 }
				
						
				
	}


	
}
