package com.hampcode.articlesapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hampcode.articlesapp.common.PageInitPaginationStudent;
import com.hampcode.articlesapp.common.PageInitPaginationStudent_Course;
import com.hampcode.articlesapp.model.Course;
import com.hampcode.articlesapp.model.Student;
import com.hampcode.articlesapp.model.Student_Course;
import com.hampcode.articlesapp.service.CourseService;
import com.hampcode.articlesapp.service.EnrollmentService;
import com.hampcode.articlesapp.service.StudentService;
import com.hampcode.articlesapp.service.Student_CourseService;
import com.hampcode.articlesapp.service.impl.AccountServiceImpl;

@Controller
@RequestMapping("/studentCourses")
public class Student_CourseController {

	protected static final String STUDENT_COURSE_VIEW = "studentCourses/showStudentCourse"; // view template for single article
	protected static final String STUDENT_COURSE_ADD_FORM_VIEW = "studentCourses/newStudentCourse"; // form for new article
	protected static final String STUDENT_COURSE_EDIT_FORM_VIEW = "studentCourses/editStudentCourse"; // form for editing an article
	protected static final String STUDENT_COURSE_PAGE_VIEW = "studentCourses/allStudentCourses"; // list with pagination
	
	protected static final String STUDENT_COURSE_QUERYS= "studentCourses/querysStudentCourses"; // list with pagination
	
	protected static final String INDEX_VIEW = "index"; // articles with pagination
	
	@Autowired
	private PageInitPaginationStudent_Course pageInitPaginationStudentCourse;
	
	@Autowired
	private Student_CourseService studentCourseService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EnrollmentService enrollmentService;
	
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	@Autowired
	private CourseService courseService;
	
	private Integer actualSemester=201802;
	private Integer searchedSemester;
	
	@GetMapping
	public ModelAndView getStudentCoursesBySemester(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationStudentCourse.initPaginationSearchBySemester(pageSize, page, STUDENT_COURSE_PAGE_VIEW,searchedSemester);
		return modelAndView;
	}
		
	@GetMapping("/querysStudents")
	public ModelAndView listAllStudent(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page,@RequestParam("semester") Integer semester) {
		searchedSemester=semester;
		ModelAndView modelAndView = pageInitPaginationStudentCourse.initPaginationSearchBySemester(pageSize, page, STUDENT_COURSE_QUERYS,semester);
		return modelAndView;
	}
	
	//Matricular alumno y restar uno a la cantidad de vacantes disponibles para el curso
	@PostMapping("/create")
	public String createStudentCourse(@Valid Course course, BindingResult result, Model model, RedirectAttributes attr) {

		if (studentCourseService.ValidateCoursesStudentRegistered(course).isEmpty()) {
			attr.addFlashAttribute("error", "Usted ya se encuentra matriculado en este curso");
			return "redirect:/courses/";
		} else {
		Student_Course studentCourse = new Student_Course();
		studentCourse.setCourse(course);
		studentCourse.setStudent(studentService.findStudentByAccount(accountServiceImpl.getLoggedUser().getId()));
		studentCourse.setEnrollment(enrollmentService.FindBySemester(actualSemester));
		course.setAmount(course.getAmount()-1);
		studentCourseService.createStudentCourse(studentCourse);
		//Student_Course newStudentCourse = studentCourseService.createStudentCourse(studentCourse);
		//model.addAttribute("student", newStudent);

		return "redirect:/courses/"; //+ newStudent.getId();//verificar despues
		}
	}
	
	@GetMapping("/semesterSearched")
	public ModelAndView getStudentCoursesBySemester(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page,@RequestParam("semester") Integer semester) {
		ModelAndView modelAndView = pageInitPaginationStudentCourse.initPaginationSearchBySemester(pageSize, page, STUDENT_COURSE_PAGE_VIEW,semester);
		return modelAndView;
	}
	
	//Desmatricular alumno y sumar uno a la cantidad de vacantes para curso
	@GetMapping(value = "/{id}/delete")
	public String deleteStudentCourse(@PathVariable("id") Long courseToDeleteId) {
		Course course=courseService.findById(courseToDeleteId);
		course.setAmount(course.getAmount()+1);
		studentCourseService.deleteStudentCourse(courseToDeleteId);
		return "redirect:/studentCourses/semesterSearched";
	}
}
