package com.example.FeelUDo.domain.job.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostJobInfoReq {

    @Schema(description = "직업 이름")
    private String jobInfoName;
    @Schema(description = "자격 나이")
    private Long qualifiedAge;
    @Schema(description = "상세 내용")
    private String details;
    @Schema(description = "우대 조건")
    private String specialCondition;
}