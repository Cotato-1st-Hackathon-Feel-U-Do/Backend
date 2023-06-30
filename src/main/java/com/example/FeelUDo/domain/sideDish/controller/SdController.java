package com.example.FeelUDo.domain.sideDish.controller;

import com.example.FeelUDo.domain.sideDish.dto.GetSideDishDetails;
import com.example.FeelUDo.domain.sideDish.dto.GetSideDishRes;
import com.example.FeelUDo.domain.sideDish.dto.PostSideDishReq;
import com.example.FeelUDo.domain.sideDish.entity.SideDish;
import com.example.FeelUDo.domain.sideDish.service.SdService;
import com.example.FeelUDo.global.dto.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/sd")
@RequiredArgsConstructor
public class SdController {

    private final SdService sdService;

    // 반찬 리스트 다 보여주기 - cred
    @GetMapping("/{userIndex}")
    @Operation(summary = "(Get) 반찬 리스트", description = "테스트 용 API 입니다. ")
    public ApplicationResponse<List<GetSideDishRes>> readSideDish(@PathVariable Long userIndex) {
        return ApplicationResponse.ok(sdService.readSideDish(userIndex));
    }

    // 반찬 등록하기
    @PostMapping("/{userIndex}")
    @Operation(summary = "(Get) 반찬 리스트", description = "테스트 용 API 입니다. ")
    public ApplicationResponse<?> createSideDish(@PathVariable Long userIndex,
                                                 @RequestBody PostSideDishReq postSideDishReq) {
        return ApplicationResponse.ok(sdService.createSideDish(userIndex, postSideDishReq));
    }

    //반찬 상세 페이지 : 일반 사용자가 보는것?
    @GetMapping("/details/{sideDishIndex}")
    @Operation(summary = "(Get) 반찬 상세 리스트",description = "테스트 용 API 입니다.")
    public ApplicationResponse<GetSideDishDetails> readDetailSideDish(@PathVariable Long sideDishIndex){
        return ApplicationResponse.ok(sdService.readSideDishDetails(sideDishIndex));
    }
}
