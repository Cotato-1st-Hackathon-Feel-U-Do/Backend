package com.example.FeelUDo.domain.sideDish.dto;

import com.example.FeelUDo.domain.sideDish.entity.SideDish;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
@Builder
public class GetSideDishDetailsRes {

    @Schema(description = "반찬 인덱스",defaultValue = "1")
    private Long sideDishIndex;

    @Schema(description = "반찬 이름",defaultValue = "1")
    private String name;
    @Schema(description = "반찬 가격", defaultValue = "오이김치")
    private Long price;
    @Schema(description = "반찬 사진")
    private String photo;

    public GetSideDishDetailsRes(Optional<SideDish> sideDish) {
        this.sideDishIndex = sideDish.get().getSideDishIndex();
        this.name = sideDish.get().getDishName();
        this.price = sideDish.get().getPrice();
        this.photo = sideDish.get().getPhotoUrl();
    }
}
