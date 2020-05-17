package com.hampcode.articlesapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hampcode.articlesapp.model.Account;
import com.hampcode.articlesapp.model.Course;
import com.hampcode.articlesapp.model.Student_Course;
import com.hampcode.articlesapp.repository.Student_CourseRepository;
import com.hampcode.articlesapp.service.Student_CourseService;

@Service
public class Student_CourseServiceImpl implements Student_CourseService {

	@Autowired
	private Student_CourseRepository studentCourseRepository;
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	//En el Controller: Usar el metodo Set para agregar los primary Keys al studentCourse y de ahi hacer 
	//la funcion createStudentCourse
	@Override
	public Student_Course createStudentCourse(Student_Course studentCourse) {
		Student_Course newStudentCourse;
		newStudentCourse = studentCourseRepository.save(studentCourse);
		return newStudentCourse;
	}

	@Override
	public Student_Course updateStudentCourse(Long id, Student_Course studentCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudentCourse(Long studentCourseId) {
		// TODO Auto-generated method stub
	}

	@Override
	public Student_Course findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student_Course getLatestEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	/*//Listar cursos según semestre ingresado
	@Override
	public List<Student_Course> findCoursesBySemester(Integer semester) {
		Account account=accountServiceImpl.getLoggedUser();
		return studentCourseRepository.findCoursesBySemester(semester, studentServiceImpl.findStudentByAccount(account.getId()));
	}

	//Verificar si Alumno ya se matriculo en un Curso
	@Override
	public List<Course> ValidateCoursesStudentRegistered(Course course) {
		Account account=accountServiceImpl.getLoggedUser();
		return studentCourseRepository.CourseStudentRegistered(course, studentServiceImpl.findStudentByAccount(account.getId()));
	}*/

	//Eliminar curso que el alumno ya está matriculado
	@Override
	public void deleteCourseStudentRegistered(Course course) {
		Account account=accountServiceImpl.getLoggedUser();
		studentCourseRepository.delete(studentCourseRepository.DeleteCourseStudentRegistered(course, studentServiceImpl.findStudentByAccount(account.getId())));
	}

	//Version en Pageable
	@Override
	public Page<Student_Course> findCoursesBySemester(Integer semester, Pageable pageable) {
		Account account=accountServiceImpl.getLoggedUser();
		return studentCourseRepository.findCoursesBySemester(semester, studentServiceImpl.findStudentByAccount(account.getId()), pageable);
	}

	@Override
	public Page<Course> CourseStudentRegistered(Course course, Pageable pageable) {
		Account account=accountServiceImpl.getLoggedUser();
		return studentCourseRepository.CourseStudentRegistered(course, studentServiceImpl.findStudentByAccount(account.getId()), pageable);
	}
	
	@Override
	public Page<Course> ValidateCoursesStudentRegistered(Course course) {
		Account account=accountServiceImpl.getLoggedUser();
		return studentCourseRepository.CourseStudentRegistered(course, studentServiceImpl.findStudentByAccount(account.getId()));
	}
}
