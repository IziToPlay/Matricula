package com.hampcode.articlesapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.hampcode.articlesapp.model.Account;
import com.hampcode.articlesapp.model.Course;
import com.hampcode.articlesapp.model.Student_Course;

public interface Student_CourseService {
	
	//List<Product> getAllProducts();
	
	Student_Course createStudentCourse(Student_Course studentCourse);
	
	Student_Course updateStudentCourse(Long id, Student_Course studentCourse);
	
	void deleteStudentCourse(Long studentCourseId);
	
	Student_Course findById(Long id);
	
	Student_Course getLatestEntry();
	
	List<Student_Course> findCoursesBySemester(Integer semester);
	
	List<Course> ValidateCoursesStudentRegistered(Course course);
	
	Page<Student_Course> findCoursesBySemester(Integer semester, Pageable pageable);
	
	Page<Course> CourseStudentRegistered(Course course,Pageable pageable);
	
	void deleteCourseStudentRegistered(Course course);
	
	
	
    //Page<Product> findAll(Pageable pageable);

    //Page<Product> finByName(String name,Pageable pageable);
}
