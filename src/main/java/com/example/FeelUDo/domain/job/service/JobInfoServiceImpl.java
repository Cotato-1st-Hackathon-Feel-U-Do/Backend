package com.example.FeelUDo.domain.job.service;

import com.example.FeelUDo.domain.job.dto.response.GetJobInfoDetailRes;
import com.example.FeelUDo.domain.job.dto.response.GetJobTypeInfoListRes;
import com.example.FeelUDo.domain.job.dto.response.GetJobTypeRes;
import com.example.FeelUDo.domain.job.dto.PostJobInfoReq;
import com.example.FeelUDo.domain.job.entity.JobInfo;
import com.example.FeelUDo.domain.job.entity.JobType;
import com.example.FeelUDo.domain.job.repository.JobInfoRepository;
import com.example.FeelUDo.domain.job.repository.JobTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobInfoServiceImpl implements JobInfoService{

    private final JobTypeRepository jobTypeRepository;
    private final JobInfoRepository jobInfoRepository;

    @Override
    public List<GetJobTypeRes> readJobType() {
        List<JobType> jobTypeList = jobTypeRepository.findAll();
        List<GetJobTypeRes> getJobTypeResList = new ArrayList<>();
        jobTypeList.forEach( jobType ->{
            GetJobTypeRes getJobTypeRes = GetJobTypeRes.of(jobType);
            getJobTypeResList.add(getJobTypeRes);
        });
        return getJobTypeResList;
    }

    @Override
    public List<GetJobTypeInfoListRes> readJobTypeInfoList(Long jobIndex) {
        JobType jobType = jobTypeRepository.findById(jobIndex)
                .orElseThrow();
        List<JobInfo> jobInfoList = jobInfoRepository.findByJobType(jobType);

        List<GetJobTypeInfoListRes> list = new ArrayList<>();
        jobInfoList.forEach(jobInfo -> {
            GetJobTypeInfoListRes getJobTypeInfoListRes = GetJobTypeInfoListRes.of(jobInfo);
            list.add(getJobTypeInfoListRes);
        });
        return list;
    }

    @Override
    public GetJobInfoDetailRes readJobInfoDetail(Long jobInfoIndex) {
        JobInfo jobInfo = jobInfoRepository.findById(jobInfoIndex)
                .orElseThrow();
        return GetJobInfoDetailRes.of(jobInfo);
    }

//    @Override
//    @Transactional
//    public String createJobInfo(Long userIndex, PostJobInfoReq postJobInfoReq) {
//        // 일자리 등록
////        JobInfo jobInfo = JobInfo.builder()
////                // 한 줄 더 들어가야.. 뭐더
////                .jobInfoName(postJobInfoReq.getJobInfoName())
////                .qualifiedAge(postJobInfoReq.getQualifiedAge())
////                .details(postJobInfoReq.getDetails())
////                .specialCondition(postJobInfoReq.getSpecialCondition())
////                .build();
////        JobInfo saveJobInfo = jobInfoRepository.save(jobInfo);
//        return "생성되었습니다.";
//    }

}
