package com.example.FeelUDo.domain.sideDish.service;

import com.example.FeelUDo.domain.sideDish.dto.GetSideDishDetails;
import com.example.FeelUDo.domain.sideDish.dto.GetSideDishRes;
import com.example.FeelUDo.domain.sideDish.dto.PostSideDishReq;
import com.example.FeelUDo.domain.sideDish.entity.SideDish;

import java.util.List;

public interface SdService {
    List<GetSideDishRes> readSideDish(Long userIndex);

    String createSideDish(Long userIndex, PostSideDishReq postSideDishReq);

    GetSideDishDetails readSideDishDetails(Long sideDishIndex);

    //반찬 구매 요청 -> 구매자의 phone number전달?
}
