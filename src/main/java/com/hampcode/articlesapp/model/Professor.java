package com.hampcode.articlesapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "professors")
public class Professor {
	
	@Id
	@Column(name = "professor_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message="Ingrese nombre")
	private String name;
	
	@NotEmpty(message="Ingrese apellido")
	private String lastName;

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
}