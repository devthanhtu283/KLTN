package com.demo.entities;// default package
// Generated Jan 27, 2025, 4:56:06 PM by Hibernate Tools 4.3.6.Final

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Experience generated by hbm2java
 */
@Entity
@Table(name = "experience", catalog = "jobs")
public class Experience implements java.io.Serializable {

	private Integer id;
	private String name;
	private boolean status;
	private Set<Job> jobs = new HashSet<Job>(0);

	public Experience() {
	}

	public Experience(String name, boolean status) {
		this.name = name;
		this.status = status;
	}

	public Experience(String name, boolean status, Set<Job> jobs) {
		this.name = name;
		this.status = status;
		this.jobs = jobs;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 65535)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "experience")
	public Set<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

}
