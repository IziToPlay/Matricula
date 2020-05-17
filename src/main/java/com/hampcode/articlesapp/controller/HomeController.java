package com.hampcode.articlesapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hampcode.articlesapp.common.PageInitPaginationCourse;
import com.hampcode.articlesapp.common.PagerModel;
import com.hampcode.articlesapp.model.Article;
import com.hampcode.articlesapp.service.CourseService;

@Controller
@RequestMapping({ "/", "/home" })

public class HomeController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private PageInitPaginationCourse pageInitPaginationCourse;

	protected static final String INDEX_VIEW = "index"; // articles with pagination

	protected static final String ARTICLE_VIEW = "courses/showCourse"; // view template for single article

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public ModelAndView getIndex(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationCourse.initPagination(pageSize, page, INDEX_VIEW);
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public String getCourseById(@PathVariable(value = "id") Long courseId, Model model) {
		model.addAttribute("course", courseService.findById(courseId));
		return ARTICLE_VIEW;
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping
	public ModelAndView getCoursesAvailables(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitPaginationCourse.initPaginationStudent(pageSize, page, INDEX_VIEW);
		return modelAndView;
	}
	
	
	@GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}
