package com.example.FeelUDo.domain.sideDish.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GetSideDishRes {
    @Schema(description = "반찬 인덱스", defaultValue = "1")
    private Long sideDishIndex;
    @Schema(description = "반찬 이름", defaultValue = "1")
    private String name;
    @Schema(description = "반찬 가격", defaultValue = "오이김치")
    private Long price;
    @Schema(description = "반찬 사진")
    private String photo;

    // 유저 정보
//    @Schema(description = "반찬 이름", defaultValue = "1")
//    private String name;

    // 유저 좋아요 유무

}
