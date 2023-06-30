package com.example.FeelUDo.domain.job.service;

import com.example.FeelUDo.domain.job.dto.GetJobInfoRes;
import com.example.FeelUDo.domain.job.dto.PostJobInfoReq;

import java.util.List;

public interface JobInfoService {
    List<GetJobInfoRes> readJobInfo(Long userIndex);
    String createJobInfo(Long userIndex, PostJobInfoReq postJobInfoReq);
}
