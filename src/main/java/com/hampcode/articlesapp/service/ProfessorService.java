package com.hampcode.articlesapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hampcode.articlesapp.model.Professor;

public interface ProfessorService {
	
	List<Professor> getAllProfessors();
	
	Professor createProfessor(Professor professor);
	
	Professor updateProfessor(Long id, Professor professor);
	
	void deleteProfessor(Long professorId);
	
	Professor findById(Long id);
	
	
	Professor getLatestEntry();
	
	
    Page<Professor> findAll(Pageable pageable);

    Page<Professor> findById(Long id,Pageable pageable);
    
    /*Page<Professor> findByLastName(String lastName,Pageable pageable);*/
}
