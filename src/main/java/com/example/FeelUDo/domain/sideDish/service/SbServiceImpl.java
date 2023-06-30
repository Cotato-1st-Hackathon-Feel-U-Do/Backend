package com.example.FeelUDo.domain.sideDish.service;

import com.example.FeelUDo.domain.sideDish.dto.GetSideDishRes;
import com.example.FeelUDo.domain.sideDish.dto.PostSideDishReq;
import com.example.FeelUDo.domain.sideDish.entity.SideDish;
import com.example.FeelUDo.domain.sideDish.entity.Tag;
import com.example.FeelUDo.domain.sideDish.repository.SideDishRepository;
import com.example.FeelUDo.domain.sideDish.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SbServiceImpl implements SdService{

    private final SideDishRepository sideDishRepository;
    private final TagRepository tagRepository;


    @Override
    public List<GetSideDishRes> readSideDish(Long userIndex) {

        List<SideDish> sideDishList = sideDishRepository.findAll();
        List<GetSideDishRes> getSideDishResList = new ArrayList<>();

        for(int i=0; i<sideDishList.size(); i++){
            SideDish sideDish = sideDishList.get(i);
            GetSideDishRes getSideDishRes = GetSideDishRes.builder()
                    .sideDishIndex(sideDish.getSideDishIndex())
                    .name(sideDish.getDishName())
                    .sideDishIndex(sideDish.getPrice())
                    .sideDishIndex(sideDish.getPrice())
                    .build();
            getSideDishResList.add(getSideDishRes);
        }
        return getSideDishResList;
    }

    @Override
    @Transactional
    public String createSideDish(Long userIndex, PostSideDishReq postSideDishReq) {

        // 반찬 등록
        SideDish sideDish = SideDish.builder()
                .userIndex(userIndex)
                .dishName(postSideDishReq.getName())
                .price(postSideDishReq.getPrice())
                .photoUrl(postSideDishReq.getPhotoUrl())
                .location(postSideDishReq.getLocation())
                .build();

        SideDish saveSideDish = sideDishRepository.save(sideDish);

        // 태그 등록
        if(postSideDishReq.getTags() != null){
            postSideDishReq.getTags().forEach( content ->{
                Tag tag = Tag.of(saveSideDish, content);
                tagRepository.save(tag);
            });
        }

        return "생셩되었습니다.";
    }

}
