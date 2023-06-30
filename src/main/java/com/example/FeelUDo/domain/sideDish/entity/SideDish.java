package com.example.FeelUDo.domain.sideDish.entity;


import com.example.FeelUDo.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class SideDish extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "side_dish_index")
    private Long sideDishIndex;

    @Column(name = "user_index",nullable = false)
    private Long userIndex;  // 판매자

    @Column(name = "dish_name",nullable = false)
    private String dishName;

    @Column(name = "price",nullable = false)
    private Long price;
    @Column(columnDefinition = "TEXT",name = "photo_urlfix",nullable = false)
    private String photoUrl;
    @Column(name = "contact",nullable = false)
    private String contact;
    @Column(name = "location",nullable = false)
    private String location;

    @Builder
    public SideDish(Long userIndex, String dishName, Long price, String photoUrl, String location) {
        this.userIndex = userIndex;
        this.dishName = dishName;
        this.price = price;
        this.photoUrl = photoUrl;
        this.location = location;
    }

}
