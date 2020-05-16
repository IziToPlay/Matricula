package com.hampcode.articlesapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.hampcode.articlesapp.model.Account;
import com.hampcode.articlesapp.model.Course;

public interface CourseService {

	List<Course> getAllCourses();
	
	Course createCourse(Course course);
	
	Course updateCourse(Long id, Course course);
	
	void deleteCourse(Long courseId);
	
	Course findById(Long id);
	
	Course getLatestEntry();
	
    Page<Course> findAll(Pageable pageable);

    Page<Course> findByName(String name,Pageable pageable);
    
    Page<Course> findCoursesAvailables(Pageable pageable);
    
    Course findByName(String name);
    
    List<Course> findCoursesAvailables();
}
