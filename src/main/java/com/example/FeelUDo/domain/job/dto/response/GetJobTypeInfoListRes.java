package com.example.FeelUDo.domain.job.dto.response;

import com.example.FeelUDo.domain.job.entity.JobInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetJobTypeInfoListRes {
    private Long jobInfoIndex;
    private String jobInfoName;
    private Long qualifiedAge;

    public static GetJobTypeInfoListRes of(JobInfo jobInfo){
        return GetJobTypeInfoListRes.builder()
                .jobInfoIndex(jobInfo.getJobInfoIndex())
                .jobInfoName(jobInfo.getJobInfoName())
                .qualifiedAge(jobInfo.getQualifiedAge())
                .build();
    }
}
