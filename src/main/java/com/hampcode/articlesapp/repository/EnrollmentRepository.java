package com.hampcode.articlesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hampcode.articlesapp.model.Student_Course;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.hampcode.articlesapp.model.Account;
import com.hampcode.articlesapp.model.Course;
import com.hampcode.articlesapp.model.Enrollment;
import com.hampcode.articlesapp.model.Student;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>{
	
	@Query("SELECT e FROM Enrollment e WHERE e.semester=:semester")
	Enrollment FindBySemester(@Param("semester") Integer semester);
}
