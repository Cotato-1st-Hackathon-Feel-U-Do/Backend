package com.example.FeelUDo.domain.directMessage.dto;

import com.example.FeelUDo.domain.directMessage.entity.DmMessage;
import lombok.Getter;

@Getter
public class MessageReq {

    private DmMessage.MessageType messageType;
    private Long roomId;
    private Long senderId;
    private String message;

}
