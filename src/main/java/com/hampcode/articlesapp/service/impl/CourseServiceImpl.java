package com.hampcode.articlesapp.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hampcode.articlesapp.model.Course;
import com.hampcode.articlesapp.service.CourseService;

public class CourseServiceImpl implements CourseService {

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course createCourse(Course coure) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course updateCourse(Long id, Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCourse(Long courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getLatestEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Course> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Course> findByName(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
