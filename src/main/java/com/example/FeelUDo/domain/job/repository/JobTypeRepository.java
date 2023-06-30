package com.example.FeelUDo.domain.job.repository;

import com.example.FeelUDo.domain.job.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType, Long> {
}
