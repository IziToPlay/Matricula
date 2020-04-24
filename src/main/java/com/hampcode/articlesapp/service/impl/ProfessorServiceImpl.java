package com.hampcode.articlesapp.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hampcode.articlesapp.model.Professor;
import com.hampcode.articlesapp.service.ProfessorService;

public class ProfessorServiceImpl implements ProfessorService {

	@Override
	public List<Professor> getAllProfessors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor createProfessor(Professor professor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor updateProfessor(Long id, Professor professor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProfessor(Long professorId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Professor findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor getLatestEntry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Professor> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Professor> findByName(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Professor> findByLastName(String lastName, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
