package com.example.FeelUDo.domain.job.controller;

import com.example.FeelUDo.domain.job.dto.response.GetJobInfoDetailRes;
import com.example.FeelUDo.domain.job.dto.response.GetJobTypeInfoListRes;
import com.example.FeelUDo.domain.job.dto.response.GetJobTypeRes;
import com.example.FeelUDo.domain.job.dto.PostJobInfoReq;
import com.example.FeelUDo.domain.job.service.JobInfoService;
import com.example.FeelUDo.domain.user.jwt.AuthTokensGenerator;
import com.example.FeelUDo.global.dto.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/job")
@RequiredArgsConstructor
public class JobController {

    private final JobInfoService jobInfoService;

    private final AuthTokensGenerator authTokensGenerator;

    @GetMapping("")
    @Operation(summary = "Job type 목록")
    @ApiResponse(responseCode = "200", description = "성공하였습니다.", content = @Content(schema = @Schema(implementation = GetJobTypeRes.class)))
    public ApplicationResponse<List<GetJobTypeRes>> readJobType() {
        return ApplicationResponse.ok(jobInfoService.readJobType());
    }

    @GetMapping("/{jobIndex}")
    @Operation(summary = "(Get) 일자리 목록 보여주는 ", description = "일자리 목록 보여주는 API 입니다.")
    @ApiResponse(responseCode = "200", description = "성공하였습니다.", content = @Content(schema = @Schema(implementation = GetJobTypeInfoListRes.class)))
    public ApplicationResponse<List<GetJobTypeInfoListRes>> readJobTypeInfoList(@PathVariable Long jobIndex) {
        return ApplicationResponse.ok(jobInfoService.readJobTypeInfoList(jobIndex));
    }

    @GetMapping("/{jobInfoIndex}")
    @Operation(summary = "(Get) 직업 상세 보기 ")
    @ApiResponse(responseCode = "200", description = "성공하였습니다.", content = @Content(schema = @Schema(implementation = GetJobInfoDetailRes.class)))
    public ApplicationResponse<GetJobInfoDetailRes> readJobInfoDetail(@PathVariable Long jobInfoIndex) {
        return ApplicationResponse.ok(jobInfoService.readJobInfoDetail(jobInfoIndex));
    }


//    @PostMapping("/{jobIndex}")
//    @Operation(summary = "(Post) 직업 리스트")
//    public ApplicationResponse<?> createJobInfo(@PathVariable Long jobIndex,
//                                                @RequestBody PostJobInfoReq postJobInfoReq) {
//        Long userIndex = authTokensGenerator.getAccessToken();
//        return ApplicationResponse.ok(jobInfoService.createJobInfo(jobIndex, postJobInfoReq));
//    }

    // post - 직업 정보 추가

    // put - 직업 정보 수정


}