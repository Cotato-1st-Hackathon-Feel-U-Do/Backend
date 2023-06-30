package com.example.FeelUDo.domain.sideDish.entity;

import com.example.FeelUDo.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_index")
    private Long tagIndex;

    @JoinColumn(name = "side_dish_index",nullable = false)
    @ManyToOne
    private SideDish sideDish;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

}
