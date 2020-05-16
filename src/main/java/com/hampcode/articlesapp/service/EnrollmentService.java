package com.hampcode.articlesapp.service;

import com.hampcode.articlesapp.model.Enrollment;

public interface EnrollmentService  {

	Enrollment FindBySemester(Integer semester);
}
