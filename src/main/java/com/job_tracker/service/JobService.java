package com.job_tracker.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.job_tracker.dto.JobRequest;
import com.job_tracker.dto.JobResponse;
import com.job_tracker.dto.StatusUpdateRequest;
import com.job_tracker.model.JobApplication;
import com.job_tracker.model.User;
import com.job_tracker.repository.JobApplicationRepository;
import com.job_tracker.repository.UserRepository;

@Service
public class JobService {
    private final JobApplicationRepository jobRepository;
    private final UserRepository userRepository;

    public JobService(JobApplicationRepository jobRepository, UserRepository userRepository) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    private JobResponse toResponse(JobApplication job) {
        return new JobResponse(job.getId(), job.getCompanyName(), job.getRole(), job.getJobUrl(), job.getNotes(),
                job.getStatus(), job.getAppliedDate(), job.getUpdatedAt());
    }

    public JobResponse addJob(JobRequest request) {
        User user = getCurrentUser();
        JobApplication job = new JobApplication();
        job.setCompanyName(request.getCompanyName());
        job.setRole(request.getRole());
        job.setJobUrl(request.getJobUrl());
        job.setNotes(request.getNotes());
        job.setUser(user);
        return toResponse(jobRepository.save(job));
    }

    public List<JobResponse> getAllJobs() {
        User user = getCurrentUser();
        return jobRepository.findByUserId(user.getId()).stream().map(this::toResponse).collect(Collectors.toList());
    }

    // ← NEW: update full job (used for notes editing)
    public JobResponse updateJob(Long jobId, JobRequest request) {
        User user = getCurrentUser();
        JobApplication job = jobRepository.findByIdAndUserId(jobId, user.getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));
        job.setCompanyName(request.getCompanyName());
        job.setRole(request.getRole());
        job.setJobUrl(request.getJobUrl());
        job.setNotes(request.getNotes());
        return toResponse(jobRepository.save(job));
    }

    public JobResponse updateStatus(Long jobId, StatusUpdateRequest request) {
        User user = getCurrentUser();
        JobApplication job = jobRepository.findByIdAndUserId(jobId, user.getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));
        job.setStatus(request.getStatus());
        return toResponse(jobRepository.save(job));
    }

    public void deleteJob(Long jobId) {
        User user = getCurrentUser();
        JobApplication job = jobRepository.findByIdAndUserId(jobId, user.getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));
        jobRepository.delete(job);
    }
}