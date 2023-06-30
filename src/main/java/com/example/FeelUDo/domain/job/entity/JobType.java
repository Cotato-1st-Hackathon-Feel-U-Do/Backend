package com.example.FeelUDo.domain.job.entity;

import com.example.FeelUDo.domain.user.entity.User;
import com.example.FeelUDo.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter

@Builder
public class JobType extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_index")
    private Long jobIndex;

    @Column(name = "job_type_name",nullable = false)
    private String jobTypeName;

    @Column(name = "join_age",nullable = false)
    private Long joinAge;

    // user : job => 1 : N
    @JoinColumn(name = "user_index")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
