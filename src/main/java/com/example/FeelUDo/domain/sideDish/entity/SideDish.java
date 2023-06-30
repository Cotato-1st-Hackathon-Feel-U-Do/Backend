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
    private Long userIndex;

    @Column(name = "dish_name",nullable = false)
    private String dishName;

    @Column(name = "price",nullable = false)
    private Long price;
    @Column(columnDefinition = "TEXT",name = "photo",nullable = false)
    private String photoUrl;
    @Column(name = "contact",nullable = false)
    private String contact;
    @Column(name = "location",nullable = false)
    private String location;


}
