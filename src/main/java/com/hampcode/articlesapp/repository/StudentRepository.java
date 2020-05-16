package com.hampcode.articlesapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hampcode.articlesapp.model.Account;
import com.hampcode.articlesapp.model.Student;

@Repository
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
    
    @Query("SELECT s FROM Student s WHERE s.name=:name")
    List<Student> findByName(@Param("name") String name);

    @Query("SELECT s FROM Student s WHERE s.account.id=:id")
    Student findStudentByAccount(@Param("id") Long id);
    //FindById ya esta implementado en el Crud de List
    
	/**
     * @param pageable
     * @return          a page of entities that fulfill the restrictions
     *                  specified by the Pageable object
     */
    Page<Student> findAll(Pageable pageable);
    
    @Query("SELECT s FROM Student s WHERE s.id =?1")
    Page<Student> findById(Long id,Pageable pageable);
}