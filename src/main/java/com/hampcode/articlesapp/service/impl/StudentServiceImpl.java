package com.hampcode.articlesapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hampcode.articlesapp.exception.ResourceNotFoundException;
import com.hampcode.articlesapp.model.Product;
import com.hampcode.articlesapp.model.PurchaseOrder;
import com.hampcode.articlesapp.model.Student;
import com.hampcode.articlesapp.repository.StudentRepository;
import com.hampcode.articlesapp.service.StudentService;

public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().iterator().forEachRemaining(students::add);
		return students;
	}

	@Override
	public Student createStudent(Student student) {
		Student newStudent=studentRepository.save(student);
		return newStudent;
	}

	@Override
	public Student updateStudent(Long id, Student studentDetails) {
		Student student=findById(id);
		student.setCareer(studentDetails.getCareer());
		student.setCourses(studentDetails.getCourses());
		student.setLastName(studentDetails.getName());
		student.setName(studentDetails.getName());
		studentRepository.save(student);
		return student;
	}

	@Override
	public void deleteStudent(Long studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public Student findById(Long id) {
		Optional<Student> student=studentRepository.findById(id);
		
		if(!student.isPresent()) {
			throw new ResourceNotFoundException("There is no Student with ID = " + id);
		}
		return student.get();
	}

	@Override
	public Student getLatestEntry() {
		List<Student> students = getAllStudents();
		if (students.isEmpty()) {
			return null;
		} else {
			Long latestStudentID = studentRepository.findTopByOrderByIdDesc();
			return findById(latestStudentID);
		}
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		return studentRepository.findAll(pageable);
	}

	@Override
	public Page<Student> findByUserName(String userName, Pageable pageable) {
		return studentRepository.findByUserName(userName, pageable);
	}

}
