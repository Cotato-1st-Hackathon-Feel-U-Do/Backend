package com.example.FeelUDo.domain.job.dto.response;

import com.example.FeelUDo.domain.job.entity.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetJobTypeRes {
    private Long jobIndex;
    private String jobTypeName;
    private Long joinAge;

    public static GetJobTypeRes of(JobType jobType){
        return GetJobTypeRes.builder()
                .jobIndex(jobType.getJobIndex())
                .jobTypeName(jobType.getJobTypeName())
                .joinAge(jobType.getJoinAge())
                .build();
    }
}
