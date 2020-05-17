package com.hampcode.articlesapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.hampcode.articlesapp.model.Product;
import com.hampcode.articlesapp.model.Professor;
import com.hampcode.articlesapp.model.Student;
import com.hampcode.articlesapp.model.Supplier;
import com.hampcode.articlesapp.service.AccountService;
import com.hampcode.articlesapp.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	protected static final String STUDENT_VIEW = "students/showStudent"; // view template for single article
	protected static final String STUDENT_ADD_FORM_VIEW = "students/newStudent"; // form for new article
	protected static final String STUDENT_EDIT_FORM_VIEW = "students/editStudent"; // form for editing an article
	protected static final String STUDENT_PAGE_VIEW = "students/allStudents"; // list with pagination
	
	protected static final String STUDENT_QUERYS= "students/querysStudents"; // list with pagination
	
	protected static final String INDEX_VIEW = "index"; // articles with pagination
	
	@Autowired
	private PageInitPaginationStudent pageInitPaginationStudent;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AccountService accountService;
	
	private Long numerator=(long) 0;
	private List<String> careers;
	private List<Integer> semesters;
	
	@GetMapping("/{id}")
	public String getStudentById(@PathVariable(value = "id") Long studentId, Model model) {
		model.addAttribute("student", studentService.findById(studentId));
		return STUDENT_VIEW;
	}
	
	@GetMapping
	public ModelAndView getAllStudents(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationStudent.initPagination(pageSize, page, STUDENT_PAGE_VIEW);
		return modelAndView;
	}
	
	@GetMapping("/querysStudents")
	public ModelAndView listAllStudent(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationStudent.initPagination(pageSize, page, STUDENT_QUERYS);
		return modelAndView;
	}
	
	@GetMapping("/new")
	public String newStudent(Model model) {

		// in case of redirection model will contain article
		if (!model.containsAttribute("student")) {
			model.addAttribute("student", new Student());
			getAllCareers();
			model.addAttribute("careers", careers);
			getAllSemesters();
			model.addAttribute("semesters", semesters);
		}
		return STUDENT_ADD_FORM_VIEW;
	}
	
	@PostMapping("/create")
	public String createStudent(@Valid Student student, BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors()/* || productService.valid(product) == false*/) {

		
			attr.addFlashAttribute("org.springframework.validation.BindingResult.student", result);
			attr.addFlashAttribute("student", student);
			return "redirect:/students/new";
		}
		//Agregar Cuenta al Estudiante
		numerator++;
		student.setAccount(accountService.findById(numerator));
		Student newStudent = studentService.createStudent(student);
		model.addAttribute("student", newStudent);

		return "redirect:/students/" + newStudent.getId();//verificar despues
	}
	
	@GetMapping("{id}/edit")
	public String editStudent(@PathVariable(value = "id") Long studentId, Model model) {
		/*
		 * in case of redirection from '/article/{id}/update' model will contain product
		 * with field values
		 */
		if (!model.containsAttribute("student")) {
		    getAllCareers();
			model.addAttribute("careers", careers);
			getAllSemesters();
			model.addAttribute("semesters", semesters);
			model.addAttribute("student", studentService.findById(studentId));
			
		}
		return STUDENT_EDIT_FORM_VIEW;
	}
	
	@PostMapping(path = "/{id}/update")//revisar
	public String updateStudent(@PathVariable(value = "id") Long studentId, @Valid Student studentDetails,
			BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors()/* || productService.valid(productDetails) == false*/) {//revisar

			/// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.student", result);
			attr.addFlashAttribute("student", studentDetails);

			attr.addFlashAttribute("error", "No se permite esta incidencias");

			return "redirect:/students/" + studentDetails.getId() + "/edit";
		}

		studentService.updateStudent(studentId, studentDetails);
		model.addAttribute("student", studentService.findById(studentId));
		return "redirect:/students/" + studentId;
	}
	
	@GetMapping(value = "/{id}/delete")
	public String deleteStudent(@PathVariable("id") Long studentId) {
		studentService.deleteStudent(studentId);
		return "redirect:/students";
	}
	
	public void getAllCareers() {
		careers.add(0, "Ingeniería de Sistemas");
		careers.add(1, "Ingeniería de Software");
		careers.add(2, "Ingeniería Industrial");
		careers.add(3, "Economía");
		careers.add(4, "Administración");
		careers.add(5, "Ingeniería Civil");
	}
	
	public void getAllSemesters() {
		semesters.add(0, 201702);
		semesters.add(1, 201801);
		semesters.add(2, 201802);
		semesters.add(3, 201901);
		semesters.add(4, 201902);
		semesters.add(5, 202001);
	}

}
