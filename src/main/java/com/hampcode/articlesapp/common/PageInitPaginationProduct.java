package com.hampcode.articlesapp.common;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.hampcode.articlesapp.model.Product;
import com.hampcode.articlesapp.service.ProductService;

@Component
public class PageInitPaginationProduct {

	@Autowired
	private ProductService productService;

	// pagination
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10 };

	public  ModelAndView initPagination(Optional<Integer> pageSize, Optional<Integer> page, String url) {
		ModelAndView initModelView = new ModelAndView(url);
		// If pageSize == null, return initial page size
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		/*
		 * If page == null || page < 0 (to prevent exception), return initial size Else,
		 * return value of param. decreased by 1
		 */
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		
		Page<Product> productsList = productService.findAll(PageRequest.of(evalPage, evalPageSize));
		PagerModel pager = new PagerModel(productsList.getTotalPages(), productsList.getNumber(), BUTTONS_TO_SHOW);
		
		initModelView.addObject("productsList", productsList);
		initModelView.addObject("selectedPageSize", evalPageSize);
		initModelView.addObject("pageSizes", PAGE_SIZES);
		initModelView.addObject("pager", pager);
		return initModelView;
	}

	public  ModelAndView initPaginationSearch(Optional<Integer> pageSize, Optional<Integer> page, 
			String url, String name)  {
		ModelAndView initModelView = new ModelAndView(url);
		// If pageSize == null, return initial page size
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		/*
		 * If page == null || page < 0 (to prevent exception), return initial size Else,
		 * return value of param. decreased by 1
		 */
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		
		Page<Product> productsList = productService.finByName(name, PageRequest.of(evalPage,evalPageSize));
				/*
				 
				  */
				 
		PagerModel pager = new PagerModel(productsList.getTotalPages(), productsList.getNumber(), BUTTONS_TO_SHOW);
		initModelView.addObject("productsList", productsList);
		initModelView.addObject("selectedPageSize", evalPageSize);
		initModelView.addObject("pageSizes", PAGE_SIZES);
		initModelView.addObject("pager", pager);
		
		return initModelView;
	}
	
	
	

	
}

