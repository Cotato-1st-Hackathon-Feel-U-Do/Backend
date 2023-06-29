package com.example.FeelUDo.domain.user.entity;

import com.example.FeelUDo.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "user_index")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userIndex;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickName", nullable = false)
    private String nickName;

}
