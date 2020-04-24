package com.hampcode.articlesapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.hampcode.articlesapp.model.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

	/**
     * @return newest articleId
     */
    @Query(value = "SELECT MAX(id) FROM Student")
    Long findTopByOrderByIdDesc();

    /**
     * @param title     title of an article
     * @param author    author of an article
     * @return          List of articles with the same title and author
     */
    //title+author must be unique
    @Query("SELECT s FROM Student s WHERE s.name=:name and s.user.userName=:code")
    List<Student> findByNameAndUserName(@Param("name") String name, @Param("code") String code);


	/**
     * @param pageable
     * @return          a page of entities that fulfill the restrictions
     *                  specified by the Pageable object
     */
    Page<Student> findAll(Pageable pageable);
    
    
    @Query("SELECT s FROM Student s WHERE s.user.userName like %?1%")
    Page<Student> findByUserName(String userName,Pageable pageable);
}