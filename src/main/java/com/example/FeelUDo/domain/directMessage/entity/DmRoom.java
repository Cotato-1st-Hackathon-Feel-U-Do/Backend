package com.example.FeelUDo.domain.directMessage.entity;

import com.example.FeelUDo.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class DmRoom extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // AUTO_INCREMENT
    @Column(name = "dmRoomId", nullable = false)
    private Long id;

    private String roomName;  // 방이름

    private String summary; // 요약 - 계속 업데이트 됨

}
