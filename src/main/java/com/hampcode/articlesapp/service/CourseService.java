package com.hampcode.articlesapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hampcode.articlesapp.model.Course;

public interface CourseService {

	List<Course> getAllCourses();
	
	Course createCourse(Course coure);
	
	Course updateCourse(Long id, Course course);
	
	void deleteCourse(Long courseId);
	
	Course findById(Long id);
	
	Course getLatestEntry();
	
    Page<Course> findAll(Pageable pageable);

    Page<Course> findByName(String name,Pageable pageable);
}
