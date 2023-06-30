package com.example.FeelUDo.domain.job.service;

import com.example.FeelUDo.domain.job.dto.PostJobInfoReq;

public interface JobInfoService {
    String createJobInfo(Long userIndex, PostJobInfoReq postJobInfoReq);
}
