package com.job_tracker.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "job_applications")
public class JobApplication {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String companyName;

	@Column(nullable = false)
	private String role;

	private String jobUrl;
	private String notes;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ApplicationStatus status = ApplicationStatus.APPLIED;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@CreationTimestamp
	private LocalDateTime appliedDate;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public JobApplication() {
	}

	// Getters
	public Long getId() {
		return id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getRole() {
		return role;
	}

	public String getJobUrl() {
		return jobUrl;
	}

	public String getNotes() {
		return notes;
	}

	public ApplicationStatus getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}

	public LocalDateTime getAppliedDate() {
		return appliedDate;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	// Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// Builder
	public static JobApplicationBuilder builder() {
		return new JobApplicationBuilder();
	}

	public static class JobApplicationBuilder {
		private String companyName;
		private String role;
		private String jobUrl;
		private String notes;
		private ApplicationStatus status = ApplicationStatus.APPLIED;
		private User user;

		public JobApplicationBuilder companyName(String companyName) {
			this.companyName = companyName;
			return this;
		}

		public JobApplicationBuilder role(String role) {
			this.role = role;
			return this;
		}

		public JobApplicationBuilder jobUrl(String jobUrl) {
			this.jobUrl = jobUrl;
			return this;
		}

		public JobApplicationBuilder notes(String notes) {
			this.notes = notes;
			return this;
		}

		public JobApplicationBuilder status(ApplicationStatus status) {
			this.status = status;
			return this;
		}

		public JobApplicationBuilder user(User user) {
			this.user = user;
			return this;
		}

		public JobApplication build() {
			JobApplication job = new JobApplication();
			job.setCompanyName(this.companyName);
			job.setRole(this.role);
			job.setJobUrl(this.jobUrl);
			job.setNotes(this.notes);
			job.setStatus(this.status);
			job.setUser(this.user);
			return job;
		}
	}
}