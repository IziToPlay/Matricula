package com.hampcode.articlesapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hampcode.articlesapp.model.Account;
import com.hampcode.articlesapp.model.Course;
import com.hampcode.articlesapp.model.Student;

@Repository
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
    
    //Query para el Admin
    @Query("SELECT c FROM Course c WHERE c.name=:name")
    Course findByName(@Param("name") String name);

    //Query para el Alumno para ver sus cursos a matricularse
    @Query("SELECT c FROM Course c inner join Student s on c.career=s.career WHERE student.career="
    		+ "c.career AND student.semester=c.semester")
    List<Course> findCoursesAvailables(@Param("student") Student student);
        
    //FindById está incorporado en el Crud de List

	/**
     * @param pageable
     * @return          a page of entities that fulfill the restrictions
     *                  specified by the Pageable object
     */
    
  //Query para el Admin
    Page<Course> findAll(Pageable pageable);
    
  //Query para el Admin
    @Query("SELECT c FROM Course c WHERE c.name like %?1%")
    Page<Course> finByName(String name,Pageable pageable);
    
  //Query para el Alumno
    @Query("SELECT c FROM Course c inner join Student s on c.career=s.career WHERE student.career="
    		+ "c.career AND student.semester=c.semester")
    Page<Course> findCoursesAvailables(@Param("student") Student student,Pageable pageable);
}