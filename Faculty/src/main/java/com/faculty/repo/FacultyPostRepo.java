package com.faculty.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.faculty.entity.FacultyEntity;
import com.faculty.entity.FacultyPostEntity;

@Repository
public interface FacultyPostRepo extends CrudRepository<FacultyPostEntity,Integer> {

	List<FacultyPostEntity> findByFacultyEmail(String facultyEmail);
	

}
