package com.hampcode.articlesapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hampcode.articlesapp.model.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student createStudent(Student student);
	
	Student updateStudent(Long id, Student student);
	
	void deleteStudent(Long studentId);
	
	Student findById(Long id);
	
	
	Student getLatestEntry();
	
	
    Page<Student> findAll(Pageable pageable);

    Page<Student> findByUserName(String userName,Pageable pageable);
}
