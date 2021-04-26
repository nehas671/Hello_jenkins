package com.faculty.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.faculty.entity.FacultyEntity;
import com.faculty.entity.FacultyPostEntity;

@Repository
public interface FacultyRepo extends CrudRepository<FacultyEntity,Integer>  {

	FacultyEntity findByFacultyEmail(String facultyEmail);

	@Query("select faculty from FacultyEntity faculty  where facultyEmail=?1 and password=?2")
	FacultyEntity authentication(String mailid, String password);

	
}
