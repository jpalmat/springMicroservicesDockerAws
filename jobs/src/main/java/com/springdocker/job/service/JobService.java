package com.springdocker.job.service;

import java.util.List;

import com.springdocker.job.data.Job;

public interface JobService {
    List<Job> getJobs();

    void addJob(Job job);

    Job getJobById(Long id);

    boolean deleteJob(Long id);

    boolean updateJob(Long id, Job job_updated);
}
