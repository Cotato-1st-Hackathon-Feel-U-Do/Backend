package com.example.FeelUDo.domain.job.repository;

import com.example.FeelUDo.domain.job.entity.JobInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobInfoRepository extends JpaRepository<JobInfo, Long> {
}
