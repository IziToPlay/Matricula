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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "name")
	@NotEmpty(message="Ingrese nombre")
	private String name;
	
	@Column(name = "amount")
	@NotEmpty(message="Ingrese cantidad de alumnos")
	private Integer amount;
	
	@NotEmpty(message="Ingrese profesor")
	@ManyToOne
	private Professor professor;
	
	@Column(name = "semester")
	@NotEmpty(message="Ingrese ciclo del curso")
	private Integer semester;
	
	@Column(name = "career")
	@NotEmpty(message="Ingrese carrera del curso")
	private String career;
	
	@Column(name = "day")
	@NotEmpty(message="Debe ingresar el día")
	private String day;
	
	@Column(name = "start_time")
	@NotEmpty(message="Debe ingresar la hora de inicio")
	private String startTime;
	
	@Column(name = "end_time")
	@NotEmpty(message="Debe ingresar la hora de fin")
	private String endTime;
	
	//private Account user;
	
	/*@ManyToMany(mappedBy = "students")
	private List<Student> student;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
