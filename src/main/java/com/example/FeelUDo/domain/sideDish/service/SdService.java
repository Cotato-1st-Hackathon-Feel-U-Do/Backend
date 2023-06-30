package com.example.FeelUDo.domain.sideDish.service;

import com.example.FeelUDo.domain.sideDish.dto.BuySideDishRes;
import com.example.FeelUDo.domain.sideDish.dto.GetSideDishDetailsRes;
import com.example.FeelUDo.domain.sideDish.dto.GetSideDishRes;
import com.example.FeelUDo.domain.sideDish.dto.PostSideDishReq;

import java.util.List;

public interface SdService {
    List<GetSideDishRes> readSideDish();

    String createSideDish(Long userIndex, PostSideDishReq postSideDishReq);

    GetSideDishDetailsRes readSideDishDetails(Long sideDishIndex);

    //반찬 구매 요청 -> 구매자의 phone number전달?
    BuySideDishRes buySideDish(Long sideDishIndex);

}
