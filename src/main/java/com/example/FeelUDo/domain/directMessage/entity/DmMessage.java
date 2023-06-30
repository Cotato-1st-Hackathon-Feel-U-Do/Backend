package com.example.FeelUDo.domain.directMessage.entity;

import com.example.FeelUDo.domain.user.entity.User;
import com.example.FeelUDo.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class DmMessage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // AUTO_INCREMENT
    @Column(name = "dmId", nullable = false)
    private Long id;

    @ManyToOne(fetch = LAZY)  // 지연 로딩
    @JoinColumn(name="dmRoomId")
    private DmRoom dmRoom;   // 방 이름

    @OneToOne(fetch = LAZY)  // 지연 로딩
    @JoinColumn(name="userId")
    private User user;   // 메시지 보낸 사람

    private String message;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    // 메시지 타입 : 입장, 채팅
    public enum MessageType {
        ENTER, TALK
    }
}
