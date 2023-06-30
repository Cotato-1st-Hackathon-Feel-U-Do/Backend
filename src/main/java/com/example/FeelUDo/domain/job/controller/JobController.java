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

    @GetMapping("")
    @Operation(summary = "(Get) 일자리 리스트", description = "일자리 리스트 보여주는 API 입니다.")
    public ApplicationResponse<List<GetJobInfoRes>> readJobInfo() {
        Long userIndex = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(jobInfoService.readJobInfo(userIndex));
    }

    @PostMapping("/{jobIndex}")
    @Operation(summary = "(Get) 직업 리스트")
    public ApplicationResponse<?> createJobInfo(@PathVariable Long jobIndex,
                                                @RequestBody PostJobInfoReq postJobInfoReq) {
        Long userIndex = authTokensGenerator.getAccessToken();
        return ApplicationResponse.ok(jobInfoService.createJobInfo(jobIndex, postJobInfoReq));
    }

    // 직업 상세 보기

    // post - 직업 정보 추가

    // put - 직업 정보 수정

    //

}