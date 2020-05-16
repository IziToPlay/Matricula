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

import com.hampcode.articlesapp.common.PageInitPaginationProfessor;
import com.hampcode.articlesapp.model.Professor;
import com.hampcode.articlesapp.service.ProfessorService;

@Controller
@RequestMapping("/professors")
public class ProfessorController {
	protected static final String PROFESSOR_VIEW = "professors/showProfessor"; // view template for single article
	protected static final String PROFESSOR_ADD_FORM_VIEW = "professors/newProfessor"; // form for new article
	protected static final String PROFESSOR_EDIT_FORM_VIEW = "professors/editProfessor"; // form for editing an article
	protected static final String PROFESSOR_PAGE_VIEW = "professors/allProfessors"; // list with pagination
	
	protected static final String PROFESSOR_QUERYS= "professors/querysProfessors"; // list with pagination

	
	protected static final String INDEX_VIEW = "index"; // articles with pagination
	
	@Autowired
	private PageInitPaginationProfessor pageInitPaginationProfessor;
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/{id}")
	public String getProfessorById(@PathVariable(value = "id") Long professorId, Model model) {
		model.addAttribute("professor", professorService.findById(professorId));
		return PROFESSOR_VIEW;
	}

	@GetMapping
	public ModelAndView getAllProfessors(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationProfessor.initPagination(pageSize, page, PROFESSOR_PAGE_VIEW);
		return modelAndView;
	}
	
	@GetMapping("/new")
	public String newProfessor(Model model) {

		// in case of redirection model will contain article
		if (!model.containsAttribute("professor")) {
			model.addAttribute("professor", new Professor());
			}
		return PROFESSOR_ADD_FORM_VIEW;
	}
	
	@PostMapping("/create")
	public String createProfessor(@Valid Professor professor, BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors()/* || productService.valid(product) == false*/) {

		
			attr.addFlashAttribute("org.springframework.validation.BindingResult.professor", result);
			attr.addFlashAttribute("professor", professor);
			return "redirect:/professors/new";
		}
		Professor newProfessor = professorService.createProfessor(professor);
		model.addAttribute("professor", newProfessor);

		return "redirect:/professors/" + newProfessor.getId();//verificar despues
	}
	
	@GetMapping("{id}/edit")
	public String editProfessor(@PathVariable(value = "id") Long professorId, Model model) {
		/*
		 * in case of redirection from '/article/{id}/update' model will contain product
		 * with field values
		 */
		if (!model.containsAttribute("professor")) {
			model.addAttribute("professor", professorService.findById(professorId));
			
		}
		return PROFESSOR_EDIT_FORM_VIEW;
	}
	
	@PostMapping(path = "/{id}/update")//revisar
	public String updateProfessor(@PathVariable(value = "id") Long professorId, @Valid Professor professorDetails,
			BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors()/* || productService.valid(productDetails) == false*/) {//revisar

			/// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.professor", result);
			attr.addFlashAttribute("professor", professorDetails);

			attr.addFlashAttribute("error", "No se permite esta incidencia");

			return "redirect:/professors/" + professorDetails.getId() + "/edit";
		}

		professorService.updateProfessor(professorId, professorDetails);
		model.addAttribute("professor", professorService.findById(professorId));
		return "redirect:/professors/" + professorId;
	}
	
	@GetMapping(value = "/{id}/delete")
	public String deleteProfessor(@PathVariable("id") Long professorId) {
		professorService.deleteProfessor(professorId);
		return "redirect:/professors";
	}
	
	@GetMapping("/querysProfessors")
	public ModelAndView listAllProffesor(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationProfessor.initPagination(pageSize, page, PROFESSOR_QUERYS);
		return modelAndView;
	}
	
	/*
	@GetMapping("/search")
	public ModelAndView searchByName(@RequestParam("name") String gravity,
							    @RequestParam("pageSize") Optional<Integer> pageSize,
							    @RequestParam("page")Optional<Integer> page) throws Exception{
		
		ModelAndView modelAndView ;
		
		if(!gravity.isEmpty())
		{
			if(!this.pageInitPagination.initPaginationSearch(pageSize,page, PRODUCT_PAGE_VIEW, gravity).isEmpty())
			{
				modelAndView=this.pageInitPagination.initPaginationSearch(pageSize, page, PRODUCT_QUERYS, gravity);
			}else
			{
				modelAndView=this.pageInitPagination.initPagination(pageSize, page, PRODUCT_QUERYS);

			}
		}
		else
		{
			modelAndView=this.pageInitPagination.initPagination(pageSize, page, PRODUCT_QUERYS);

		}

		
		return modelAndView;
	}*/
}
