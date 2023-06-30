package com.example.FeelUDo.domain.sideDish.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BuySideDishRes {
    @Schema(description = "판매자 번호", defaultValue = "010-0000-0000")
    private String sellerContact;

    @Builder
    public BuySideDishRes(String sellerContact) {
        this.sellerContact = sellerContact;
    }
}

