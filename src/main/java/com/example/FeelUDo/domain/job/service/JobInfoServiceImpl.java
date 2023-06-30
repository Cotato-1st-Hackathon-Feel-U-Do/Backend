package com.example.FeelUDo.domain.job.service;

import com.example.FeelUDo.domain.job.dto.GetJobInfoRes;
import com.example.FeelUDo.domain.job.dto.PostJobInfoReq;
import com.example.FeelUDo.domain.job.entity.JobInfo;
import com.example.FeelUDo.domain.job.entity.JobType;
import com.example.FeelUDo.domain.job.repository.JobInfoRepository;
import com.example.FeelUDo.domain.sideDish.repository.SideDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobInfoServiceImpl implements JobInfoService{

    private final JobInfoRepository jobInfoRepository;

    @Override
    public List<GetJobInfoRes> readJobInfo(Long userIndex) {
        return null;
    }

    @Override
    @Transactional
    public String createJobInfo(Long userIndex, PostJobInfoReq postJobInfoReq) {
        // 일자리 등록
//        JobInfo jobInfo = JobInfo.builder()
//                // 한 줄 더 들어가야.. 뭐더
//                .jobInfoName(postJobInfoReq.getJobInfoName())
//                .qualifiedAge(postJobInfoReq.getQualifiedAge())
//                .details(postJobInfoReq.getDetails())
//                .specialCondition(postJobInfoReq.getSpecialCondition())
//                .build();
//        JobInfo saveJobInfo = jobInfoRepository.save(jobInfo);
        return "생성되었습니다.";
    }
}
