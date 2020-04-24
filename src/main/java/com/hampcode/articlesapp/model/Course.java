package com.hampcode.articlesapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotEmpty(message="Ingrese nombre")
	private String name;
	
	@NotEmpty(message="Ingrese cantidad")
	private String amount;
	
	@NotEmpty(message="Ingrese profesor")
	private Professor professor;
	
	@NotEmpty(message="Ingrese ciclo")
	private String semester;
	
	@Column(name = "date")
	@NotEmpty(message="Debe ingresar la fecha")
	private String date;
	
	private Account user;
	
	@ManyToMany(mappedBy = "students")
	private List<Student> student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Account getUser() {
		return user;
	}

	public void setUser(Account user) {
		this.user = user;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
