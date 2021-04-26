package com.faculty.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.faculty.dto.FacultyDto;
import com.faculty.dto.FacultyPostDto;
import com.faculty.entity.FacultyEntity;
import com.faculty.entity.FacultyPostEntity;
import com.faculty.entity.StudentInfo;
import com.faculty.exception.FacultyNotFoundException;
import com.faculty.repo.FacultyPostRepo;
import com.faculty.repo.FacultyRepo;
import com.faculty.repo.studentRepo;
import com.faculty.util.FacultyUtil;


@Service
public class FacultyServiceImpl implements FacultyService{

	@Autowired
	FacultyRepo facultyrepo;
	
	@Autowired
	FacultyPostRepo facultypostrepo;
	
	
	@Autowired
	studentRepo studentrepo;
	
	@Transactional
	@Override
	public FacultyEntity getAllFaculty(String FacultyEmail) throws FacultyNotFoundException{
		FacultyEntity facultyentity =  facultyrepo.findByFacultyEmail(FacultyEmail);
		System.out.println("facultyentity "+facultyentity);
		if(facultyentity!=null) 
		{
			
			return facultyentity;
			
		}
		else 
		{
			throw new FacultyNotFoundException("FacultyEmail : " + FacultyEmail);
		}
		
		
		
	
	}

	@Override
	public List<StudentInfo> getAllStudents() {
	List<StudentInfo> studententity =  studentrepo.findAll();
		
		return studententity;
	
	}

	@Override
	public Boolean authentication(String mailid,String password) {
	       
//      StudentInfo s = stdao.authentication(mailid,password);
//      if(s!=null) {
//          return stdao.authentication(mailid,password);
//      }else {
//          return null;
//      }
 
    Boolean found=false;
      if(mailid==null) {
          found=false;
      }
      Iterable<FacultyEntity> dealer = facultyrepo.findAll();
      for(FacultyEntity dealers:dealer) {
          if((dealers.getFacultyEmail().equals(mailid)) && (dealers.getPassword().equals(password)))
          {
              found=true;
              break;
          }
      }
      return found;
 
     
}

	@Transactional
	@Override
	public List<FacultyPostEntity> view(String facultyEmail) throws FacultyNotFoundException {
		// TODO Auto-generated method stub
		FacultyEntity facultyentity =   facultyrepo.findByFacultyEmail(facultyEmail);
		
		if(facultyentity!=null) 
		{
			System.out.println(facultyentity.getPostlist());
			return facultyentity.getPostlist();
			
		}
		else 
		{
			throw new FacultyNotFoundException("FacultyEmail : " + facultyEmail);
		}
		
		
		
		
	}

	
	
	
	
	
}
