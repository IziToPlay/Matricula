package com.hampcode.articlesapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hampcode.articlesapp.model.Course;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

	/**
     * @return newest articleId
     */
    @Query(value = "SELECT MAX(id) FROM Course")
    Long findTopByOrderByIdDesc();

    /**
     * @param title     title of an article
     * @param author    author of an article
     * @return          List of articles with the same title and author
     */
    //title+author must be unique
    @Query("SELECT c FROM Course c WHERE c.name=:name and c.professor.name=:professor")
    List<Course> findByNameAndProfessor(@Param("name") String name, @Param("professor") String professor);


	/**
     * @param pageable
     * @return          a page of entities that fulfill the restrictions
     *                  specified by the Pageable object
     */
    Page<Course> findAll(Pageable pageable);
    
    
    @Query("SELECT c FROM Course c WHERE c.name like %?1%")
    Page<Course> finByName(String enterprise,Pageable pageable);
}