package com.example.FeelUDo.domain.sideDish.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostSideDishReq {
    @Schema(description = "반찬 이름", defaultValue = "1")
    private String name;
    @Schema(description = "반찬 가격", defaultValue = "오이김치")
    private Long price;
    @Schema(description = "반찬 사진")
    private String photoUrl;
    @Schema(description = "판매자 번호")
    private String contact;
    @Schema(description = "판매 위치")
    private String location;

    // 태그 목록
    private List<String> tags;
}
