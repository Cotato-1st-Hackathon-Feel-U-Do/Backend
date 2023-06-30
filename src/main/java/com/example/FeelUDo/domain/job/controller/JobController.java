package com.example.FeelUDo.domain.job.controller;

import com.example.FeelUDo.domain.job.dto.GetJobInfoRes;
import com.example.FeelUDo.domain.job.dto.PostJobInfoReq;
import com.example.FeelUDo.domain.job.service.JobInfoService;
import com.example.FeelUDo.domain.user.jwt.AuthTokensGenerator;
import com.example.FeelUDo.global.dto.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/sd")
@RequiredArgsConstructor

public class JobController {

    private final JobInfoService jobInfoService;

    private final AuthTokensGenerator authTokensGenerator;

    // 일자리 리스트 다 보여주기 - cred
    /*@GetMapping("/{jobIndex}")
    @Operation(summary = "(Get) 일자리 리스트", description = "테스트 용 API 입니다. ")
    public ApplicationResponse<List<GetJobInfoRes>> readJobInfo(@PathVariable Long userIndex) {
        return ApplicationResponse.ok(JobInfoService.readJobInfo(userIndex));
    }

    @PostMapping("/{jobIndex}")
    @Operation(summary = "(Get) 직업 리스트", description = "테스트 용 API 입니다. ")
    public ApplicationResponse<?> createJobInfo(@PathVariable Long userIndex,
                                                 @RequestBody PostJobInfoReq postJobInfoReq) {
        return ApplicationResponse.ok(JobInfoService.createJobInfo(userIndex, postJobInfoReq));
    }*/
}