package com.example.FeelUDo.domain.job.repository;

import com.example.FeelUDo.domain.job.entity.JobInfo;
import com.example.FeelUDo.domain.job.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobInfoRepository extends JpaRepository<JobInfo, Long> {
    List<JobInfo> findByJobType(JobType jobType);
}
