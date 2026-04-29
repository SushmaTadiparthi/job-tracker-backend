package com.job_tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job_tracker.model.ApplicationStatus;
import com.job_tracker.model.JobApplication;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

	// Get all jobs for a specific user
	List<JobApplication> findByUserId(Long userId);

	// Get jobs by user and status
	List<JobApplication> findByUserIdAndStatus(Long userId, ApplicationStatus status);

	// Find specific job belonging to specific user
	Optional<JobApplication> findByIdAndUserId(Long id, Long userId);
}