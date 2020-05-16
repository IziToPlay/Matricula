package com.hampcode.articlesapp.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hampcode.articlesapp.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	/**
     * @return newest articleId
     */
    /*@Query(value = "SELECT MAX(id) FROM Course")
    Long findTopByOrderByIdDesc();

    /**
     * @param title     title of an article
     * @param author    author of an article
     * @return          List of articles with the same title and author
     */
    //title+author must be unique*/
    
	@Query("SELECT a FROM Account a WHERE a.userName=:userName")
    Account findByUserName(@Param("userName") String userName);
    
    //FindById está incorporado en el Crud de List

	/**
     * @param pageable
     * @return          a page of entities that fulfill the restrictions
     *                  specified by the Pageable object
     */
    
    /*@Query("SELECT a FROM Account a WHERE a.userName like %?1%")
    Page<Account> finByUserName(String userName,Pageable pageable)*/;
}
