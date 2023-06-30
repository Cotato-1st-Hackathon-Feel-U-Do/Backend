package com.example.FeelUDo.domain.job.entity;

import com.example.FeelUDo.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JobInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_info_index")
    private Long jobInfoIndex;

    @JoinColumn(name = "job_index",nullable = false)
    @ManyToOne
    private JobType jobType;

    @Column(name = "job_info_name",nullable = false)
    private String jobInfoName;

    @Column(name = "qualified_age",nullable = false)
    private Long qualifiedAge;

    @Column(name = "details",nullable = false)
    private String details;

    @Column(name = "special_condition",nullable = false)
    private String specialCondition;

    @Builder
    public JobInfo(JobType jobType, String jobInfoName, Long qualifiedAge, String details, String specialCondition) {
        this.jobType = jobType;
        this.jobInfoName = jobInfoName;
        this.qualifiedAge = qualifiedAge;
        this.details = details;
        this.specialCondition = specialCondition;
    }


}
