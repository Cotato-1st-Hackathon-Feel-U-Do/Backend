package com.example.FeelUDo.domain.sideDish.service;

import com.example.FeelUDo.domain.sideDish.dto.BuySideDishRes;
import com.example.FeelUDo.domain.sideDish.dto.GetSideDishDetailsRes;
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
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class SdServiceImpl implements SdService{

    private final SideDishRepository sideDishRepository;
    private final TagRepository tagRepository;


    @Override
    @Transactional
    public List<GetSideDishRes> readSideDish() {

        List<SideDish> sideDishList = sideDishRepository.findAll();
        List<GetSideDishRes> getSideDishResList = new ArrayList<>();

        for(int i=0; i<sideDishList.size(); i++){
            SideDish sideDish = sideDishList.get(i);
            GetSideDishRes getSideDishRes = GetSideDishRes.builder()
                    .sideDishIndex(sideDish.getSideDishIndex())
                    .name(sideDish.getDishName())
                    .price(sideDish.getPrice())
                    .photo(sideDish.getPhotoUrl())
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
                .contact(postSideDishReq.getContact())
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

    
    //반찬 정보 가져오기
    @Override
    @Transactional
    public GetSideDishDetailsRes readSideDishDetails(Long sideDishIndex) {
        Optional<SideDish> sideDish = sideDishRepository.findById(sideDishIndex);
        GetSideDishDetailsRes getSideDishDetailsRes = new GetSideDishDetailsRes(sideDish);

        return getSideDishDetailsRes;
    }

    @Override
    @Transactional
    public BuySideDishRes buySideDish(Long sideDishIndex) {
        Optional<SideDish> sideDish = sideDishRepository.findById(sideDishIndex);
        String contact = sideDish.get().getContact();
        BuySideDishRes buySideDishRes = new BuySideDishRes(contact);
        return buySideDishRes;
    }
}
