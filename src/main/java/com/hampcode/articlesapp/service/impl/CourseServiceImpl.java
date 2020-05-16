package com.hampcode.articlesapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hampcode.articlesapp.exception.ResourceNotFoundException;
import com.hampcode.articlesapp.model.Account;
import com.hampcode.articlesapp.model.Course;
import com.hampcode.articlesapp.model.Student;
import com.hampcode.articlesapp.repository.CourseRepository;
import com.hampcode.articlesapp.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll().iterator().forEachRemaining(courses::add);
		return courses;
	}

	@Override
	public Course createCourse(Course course) {
		Course newCourse=courseRepository.save(course);
		return newCourse;
	}

	@Override
	public Course updateCourse(Long id, Course courseDetails) {
		Course course=findById(id);
		course.setName(courseDetails.getName());
		course.setAmount(courseDetails.getAmount());
		course.setProfessor(courseDetails.getProfessor());
		course.setCareer(courseDetails.getCareer());
		course.setSemester(courseDetails.getSemester());
		course.setDay(courseDetails.getDay());
		course.setStartTime(courseDetails.getStartTime());
		course.setEndTime(courseDetails.getEndTime());
		courseRepository.save(course);
		return course;
	}
	
	@Override
	public void deleteCourse(Long courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public Course findById(Long id) {
	Optional<Course> course=courseRepository.findById(id);
		
		if(!course.isPresent()) {
			throw new ResourceNotFoundException("There is no Course with ID = " + id);
		}
		return course.get();
	}

	@Override
	public Course getLatestEntry() {
		List<Course> courses = getAllCourses();
		if (courses.isEmpty()) {
			return null;
		} else {
			Long latestCourseID = courseRepository.findTopByOrderByIdDesc();
			return findById(latestCourseID);
		}
	}

	@Override
	public Page<Course> findAll(Pageable pageable) {
		return courseRepository.findAll(pageable);
	}

	@Override
	public Page<Course> findByName(String name, Pageable pageable) {
		return courseRepository.finByName(name, pageable);
	}

	@Override
	public Page<Course> findCoursesAvailables(Pageable pageable) {
		Account account=accountServiceImpl.getLoggedUser();
		return courseRepository.findCoursesAvailables(studentServiceImpl.findStudentByAccount(account.getId()), pageable);
	}

	@Override
	public Course findByName(String name) {
		return courseRepository.findByName(name);
	}

	@Override
	public List<Course> findCoursesAvailables() {
		Account account=accountServiceImpl.getLoggedUser();
		return courseRepository.findCoursesAvailables(studentServiceImpl.findStudentByAccount(account.getId()));
	}
}
