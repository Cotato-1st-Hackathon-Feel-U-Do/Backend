package com.example.FeelUDo.domain.sideDish.service;

import com.example.FeelUDo.domain.sideDish.dto.GetSideDishRes;
import com.example.FeelUDo.domain.sideDish.dto.PostSideDishReq;

import java.util.List;

public interface SdService {
    List<GetSideDishRes> readSideDish(Long userIndex);

    String createSideDish(Long userIndex, PostSideDishReq postSideDishReq);
}
