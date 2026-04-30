package com.job_tracker.dto;

import java.time.LocalDateTime;

import com.job_tracker.model.ApplicationStatus;

public class JobResponse {

	private Long id;
	private String companyName;
	private String role;
	private String jobUrl;
	private String notes;
	private ApplicationStatus status;
	private LocalDateTime appliedDate;
	private LocalDateTime updatedAt;

	public JobResponse(Long id, String companyName, String role, String jobUrl, String notes, ApplicationStatus status,
			LocalDateTime appliedDate, LocalDateTime updatedAt) {
		this.id = id;
		this.companyName = companyName;
		this.role = role;
		this.jobUrl = jobUrl;
		this.notes = notes;
		this.status = status;
		this.appliedDate = appliedDate;
		this.updatedAt = updatedAt;
	}

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

	public LocalDateTime getAppliedDate() {
		return appliedDate;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
}