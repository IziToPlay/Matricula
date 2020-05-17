package com.hampcode.articlesapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.hampcode.articlesapp.model.Account;
import com.hampcode.articlesapp.model.Course;
import com.hampcode.articlesapp.model.Student;
import com.hampcode.articlesapp.model.Student_Course;


@Repository
public interface Student_CourseRepository extends PagingAndSortingRepository<Student_Course, Long> {
/*
	//Query para Alumno: Visualizar cursos del semestre elegido
	@Query("SELECT sc FROM Student_Course sc inner join student s on sc.student.id=s.id WHERE sc.enrollment.semester=:semester")
	List<Student_Course> findCoursesBySemester(@Param("semester") Integer semester,@Param("student") Student student);

	//Query para Alumno: Validar que ya está matriculado en un curso
	@Query("SELECT sc.course FROM Student_Course sc inner join student s on sc.student.id=s.id WHERE sc.course.id=:course.id")
	List<Course> CourseStudentRegistered(@Param("course") Course course,@Param("student") Student student);*/
	//TAMBIEN PARA
	//Query para Alumno: Eliminar curso que el alumno ya está matriculado
	@Query("SELECT sc FROM Student_Course sc inner join student s on sc.student.id=s.id WHERE sc.course.id=:course.id")
	Student_Course DeleteCourseStudentRegistered(@Param("course") Course course,@Param("student") Student student);
	
	/**
     * @param pageable
     * @return          a page of entities that fulfill the restrictions
     *                  specified by the Pageable object
     */
	
	//Query para Alumno: Visualizar cursos del semestre elegido
	@Query("SELECT sc FROM Student_Course sc inner join student s on sc.student.id=s.id WHERE sc.enrollment.semester=:semester")
	Page<Student_Course> findCoursesBySemester(@Param("semester") Integer semester,@Param("student") Student student, Pageable pageable);

	//Query para Alumno: Validar que ya está matriculado en un curso
	@Query("SELECT sc.course FROM Student_Course sc inner join student s on sc.student.id=s.id WHERE sc.course.id=:course.id")
	Page<Course> CourseStudentRegistered(@Param("course") Course course,@Param("student") Student student,Pageable pageable);
		
	@Query("SELECT sc.course FROM Student_Course sc inner join student s on sc.student.id=s.id WHERE sc.course.id=:course.id")
	Page<Course> CourseStudentRegistered(@Param("course") Course course,@Param("student") Student student);
	
	/*Page<Product> findAll(Pageable pageable);

	@Query("SELECT i FROM Product i WHERE i.name like %?1%")
	Page<Product> finByName(String gravedad,Pageable pageable);*/
}
