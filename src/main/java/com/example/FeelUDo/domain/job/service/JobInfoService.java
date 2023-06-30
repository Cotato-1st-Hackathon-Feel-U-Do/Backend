package com.example.FeelUDo.domain.job.service;

import com.example.FeelUDo.domain.job.dto.response.GetJobInfoDetailRes;
import com.example.FeelUDo.domain.job.dto.response.GetJobTypeInfoListRes;
import com.example.FeelUDo.domain.job.dto.response.GetJobTypeRes;
import com.example.FeelUDo.domain.job.dto.PostJobInfoReq;

import java.util.List;

public interface JobInfoService {
    List<GetJobTypeRes> readJobType();
    List<GetJobTypeInfoListRes> readJobTypeInfoList(Long jobIndex);
    GetJobInfoDetailRes readJobInfoDetail(Long jobInfoIndex);

//    String createJobInfo(Long userIndex, PostJobInfoReq postJobInfoReq);


}
