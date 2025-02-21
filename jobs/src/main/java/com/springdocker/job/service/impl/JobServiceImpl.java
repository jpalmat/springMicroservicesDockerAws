package com.springdocker.job.service.impl;

import java.util.List;
import java.util.Optional;

import com.springdocker.job.data.Job;
import com.springdocker.job.data.JobRepository;
import com.springdocker.job.service.JobService;

import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void addJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        // return jobs.stream().filter(j ->
        // j.getId().equals(id)).findFirst().orElse(null);
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        // return jobs.removeIf(job -> job.getId().equals(id));
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job job_updated) {
        // return jobs.stream().filter(job ->
        // job.getId().equals(id)).findFirst().map(job -> {
        // job.setTitle(job_updated.getTitle());
        // job.setDescription(job_updated.getDescription());
        // job.setLocation(job_updated.getLocation());
        // job.setMinSalary(job_updated.getMinSalary());
        // job.setMaxSalary(job_updated.getMaxSalary());
        // return true;
        // }).orElse(false);

        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(job_updated.getTitle());
            job.setDescription(job_updated.getDescription());
            job.setLocation(job_updated.getLocation());
            job.setMinSalary(job_updated.getMinSalary());
            job.setMaxSalary(job_updated.getMaxSalary());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

}
