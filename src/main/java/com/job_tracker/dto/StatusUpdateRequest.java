package com.job_tracker.dto;

import com.job_tracker.model.ApplicationStatus;

public class StatusUpdateRequest {

	private ApplicationStatus status;

	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}
}