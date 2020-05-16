package com.hampcode.articlesapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hampcode.articlesapp.model.Enrollment;
import com.hampcode.articlesapp.repository.EnrollmentRepository;
import com.hampcode.articlesapp.service.EnrollmentService;

public class EnrollmentServiceImpl implements EnrollmentService{

	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	public Enrollment FindBySemester(Integer semester) {
		return enrollmentRepository.FindBySemester(semester);
	}

}
