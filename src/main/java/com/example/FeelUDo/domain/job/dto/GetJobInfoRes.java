package com.example.FeelUDo.domain.job.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder

public class GetJobInfoRes {
    @Schema(description = "일자리 인덱스", defaultValue = "1")
    private Long jobIndex;
    @Schema(description = "일자리 정보 인덱스", defaultValue = "1")
    private Long jobInfoIndex;
    @Schema(description = "일자리 이름", defaultValue = "육아돌봄")
    private String name;
    @Schema(description = "자격 나이", defaultValue = "65")
    private Long age;
    @Schema(description = "상세 내용")
    private String details;
    @Schema(description = "우대 조건", defaultValue = "기초생활수급여부")
    private String condition;

}
