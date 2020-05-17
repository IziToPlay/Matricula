package com.hampcode.articlesapp.controller;
//VALIDAR QUE EL ALUMNO SOLO SE PUEDE MATRICULAR EN UN CURSO
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

import com.hampcode.articlesapp.common.PageInitPaginationCourse;
import com.hampcode.articlesapp.model.Course;
import com.hampcode.articlesapp.service.CourseService;
import com.hampcode.articlesapp.model.Professor;
import com.hampcode.articlesapp.service.ProfessorService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	protected static final String COURSE_VIEW = "courses/showCourse"; // view template for single article
	protected static final String COURSE_ADD_FORM_VIEW = "courses/newCourse"; // form for new article
	protected static final String COURSE_EDIT_FORM_VIEW = "courses/editCourse"; // form for editing an article
	protected static final String COURSE_PAGE_VIEW = "courses/allCourses"; // list with pagination for Admin
	
	protected static final String COURSE_QUERYS= "courses/querysCourses"; // list with pagination for Admin
	
	// list with pagination for Student
	protected static final String COURSE_PAGE_VIEW_STUDENT = "courses/allCoursesStudent"; 
	
	// list with pagination for Student
	protected static final String COURSE_QUERYS_STUDENT= "courses/querysCoursesStudent"; 

	
	protected static final String INDEX_VIEW = "index"; // articles with pagination
	
	@Autowired
	private PageInitPaginationCourse pageInitPaginationCourse;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ProfessorService professorService;
	
	private List<String> careers;
	private List<Integer> semesters;
	
	//FOR ADMIN
	@GetMapping
	public ModelAndView getAllCourses(@RequestParam("pageSize") Optional<Integer> pageSize,
				@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationCourse.initPagination(pageSize, page, COURSE_PAGE_VIEW);
		return modelAndView;
	}
		
	@GetMapping("/{id}")
	public String getCourseById(@PathVariable(value = "id") Long courseId, Model model) {
		model.addAttribute("course", courseService.findById(courseId));
		return COURSE_VIEW;
	}
	
	//FOR ADMIN
	@GetMapping("/querysCourses")
	public ModelAndView listAllCourse(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationCourse.initPagination(pageSize, page, COURSE_QUERYS);
		return modelAndView;
	}
	//FOR ADMIN
	@GetMapping("/search")
	public ModelAndView searchByName(@RequestParam("name") String gravity,
							    @RequestParam("pageSize") Optional<Integer> pageSize,
							    @RequestParam("page")Optional<Integer> page) throws Exception{
		
		ModelAndView modelAndView;
		
		if(!gravity.isEmpty())
		{
			if(!this.pageInitPaginationCourse.initPaginationSearch(pageSize,page, COURSE_PAGE_VIEW, gravity).isEmpty())
			{
				modelAndView=this.pageInitPaginationCourse.initPaginationSearch(pageSize, page, COURSE_QUERYS, gravity);
			}else
			{
				modelAndView=this.pageInitPaginationCourse.initPagination(pageSize, page, COURSE_QUERYS);

			}
		}
		else
		{
			modelAndView=this.pageInitPaginationCourse.initPagination(pageSize, page, COURSE_QUERYS);

		}
		
		return modelAndView;
	}
	
	//FOR STUDENT
	@GetMapping("/coursesAvailables")
	public ModelAndView getAllCoursesAvailables(@RequestParam("pageSize") Optional<Integer> pageSize,
				@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationCourse.initPaginationStudent(pageSize, page, COURSE_PAGE_VIEW_STUDENT);
		return modelAndView;
	}
	//FOR STUDENT	
	@GetMapping("/querysCoursesStudent")
	public ModelAndView listAllCourseAvailables(@RequestParam("pageSize") Optional<Integer> pageSize,
				@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationCourse.initPaginationStudent(pageSize, page, COURSE_QUERYS_STUDENT);
		return modelAndView;
	}
	
	@GetMapping("/new")
	public String newCourse(Model model) {

		// in case of redirection model will contain article
		if (!model.containsAttribute("course")) {
			model.addAttribute("course", new Course());
			 List<Professor> professors = professorService.getAllProfessors();
		     model.addAttribute("professors", professors);
		     getAllCareers();
			 model.addAttribute("careers", careers);
			 getAllSemesters();
			 model.addAttribute("semesters", semesters);
		}
		return COURSE_ADD_FORM_VIEW;
	}
	
	@PostMapping("/create")
	public String createCourse(@Valid Course course, BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors()/* || productService.valid(product) == false*/) {

		
			attr.addFlashAttribute("org.springframework.validation.BindingResult.course", result);
			attr.addFlashAttribute("course", course);
			return "redirect:/courses/new";
		}
		Course newCourse = courseService.createCourse(course);
		model.addAttribute("course", newCourse);

		return "redirect:/courses/" + newCourse.getId();//verificar despues
	}
	
	@GetMapping("{id}/edit")
	public String editCourse(@PathVariable(value = "id") Long courseId, Model model) {
		/*
		 * in case of redirection from '/article/{id}/update' model will contain product
		 * with field values
		 */
		if (!model.containsAttribute("course")) {
			List<Professor> professors = professorService.getAllProfessors();
		    model.addAttribute("professors", professors);
		    getAllCareers();
			model.addAttribute("careers", careers);
			getAllSemesters();
			model.addAttribute("semesters", semesters);
			model.addAttribute("course", courseService.findById(courseId));
			
		}
		return COURSE_EDIT_FORM_VIEW;
	}
	
	@PostMapping(path = "/{id}/update")//revisar
	public String updateCourse(@PathVariable(value = "id") Long courseId, @Valid Course courseDetails,
			BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors()/* || productService.valid(productDetails) == false*/) {//revisar

			/// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.course", result);
			attr.addFlashAttribute("course", courseDetails);

			attr.addFlashAttribute("error", "No se permite esta incidencias");

			return "redirect:/courses/" + courseDetails.getId() + "/edit";
		}

		courseService.updateCourse(courseId, courseDetails);
		model.addAttribute("course", courseService.findById(courseId));
		return "redirect:/courses/" + courseId;
	}
	
	@GetMapping(value = "/{id}/delete")
	public String deleteCourse(@PathVariable("id") Long courseId) {
		courseService.deleteCourse(courseId);
		return "redirect:/courses";
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
