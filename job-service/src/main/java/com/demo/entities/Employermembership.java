package com.demo.entities;// default package
// Generated Jan 27, 2025, 4:56:06 PM by Hibernate Tools 4.3.6.Final

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Employermembership generated by hbm2java
 */
@Entity
@Table(name = "employermembership", catalog = "jobs")
public class Employermembership implements java.io.Serializable {

	private Integer id;
	private Employer employer;
	private Membership membership;
	private Date startDate;
	private Date endDate;
	private Date renewalDate;
	private boolean status;
	private Set<Payment> payments = new HashSet<Payment>(0);

	public Employermembership() {
	}

	public Employermembership(Employer employer, Membership membership, Date startDate, Date endDate, Date renewalDate,
                              boolean status) {
		this.employer = employer;
		this.membership = membership;
		this.startDate = startDate;
		this.endDate = endDate;
		this.renewalDate = renewalDate;
		this.status = status;
	}

	public Employermembership(Employer employer, Membership membership, Date startDate, Date endDate, Date renewalDate,
                              boolean status, Set<Payment> payments) {
		this.employer = employer;
		this.membership = membership;
		this.startDate = startDate;
		this.endDate = endDate;
		this.renewalDate = renewalDate;
		this.status = status;
		this.payments = payments;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id", nullable = false)
	public Employer getEmployer() {
		return this.employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "membership_id", nullable = false)
	public Membership getMembership() {
		return this.membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = false, length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = false, length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "renewal_date", nullable = false, length = 19)
	public Date getRenewalDate() {
		return this.renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employermembership")
	public Set<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}
