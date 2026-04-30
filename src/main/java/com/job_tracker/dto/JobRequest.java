package com.job_tracker.dto;

public class JobRequest {

	private String companyName;
	private String role;
	private String jobUrl;
	private String notes;

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
}