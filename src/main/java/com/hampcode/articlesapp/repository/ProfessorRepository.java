package com.hampcode.articlesapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hampcode.articlesapp.model.Professor;

@Repository
public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Long> {

	/**
     * @return newest articleId
     */
    @Query(value = "SELECT MAX(id) FROM Professor")
    Long findTopByOrderByIdDesc();

    /**
     * @param title     title of an article
     * @param author    author of an article
     * @return          List of articles with the same title and author
     */
    //title+author must be unique
    /*@Query("SELECT p FROM Professor p WHERE p.id=:id")
    List<Professor> findById(@Param("id") Long id);*/
    /*El findById ya se encuentra en el Crud*/

	/**
     * @param pageable
     * @return          a page of entities that fulfill the restrictions
     *                  specified by the Pageable object
     */
    Page<Professor> findAll(Pageable pageable);
    
    
    @Query("SELECT p FROM Professor p WHERE p.id=?1")
    Page<Professor> finById(Long id,Pageable pageable);
}