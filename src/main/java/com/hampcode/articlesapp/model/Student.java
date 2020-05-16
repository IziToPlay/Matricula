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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name = "name")
	@NotEmpty(message="Ingrese nombre")
	private String name;
	
	@Column(name = "last_name")
	@NotEmpty(message="Ingrese apellido")
	private String lastName;
	
	@Column(name = "career")
	@NotEmpty(message="Ingrese carrera")
	private String career;
	
	@Column(name = "semester")
	@NotEmpty(message="Ingrese semestre")
	private Integer semester;
	
	//@NotEmpty(message="Ingrese cuenta")
	@ManyToOne
	private Account account;
	
	/*@NotEmpty(message="Seleccione curso")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "student_course", 
				joinColumns = { @JoinColumn(name = "student_id") }, 
				inverseJoinColumns = {@JoinColumn(name = "course_id") 
			})
	private List<Course> courses = new ArrayList<>();
    */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	/*public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}*/
}
