package com.example.FeelUDo.domain.directMessage.service;

import com.example.FeelUDo.domain.directMessage.dto.MessageReq;
import com.example.FeelUDo.domain.directMessage.entity.DmMessage;
import com.example.FeelUDo.domain.directMessage.entity.DmRoom;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

public interface DmService {
    DmRoom createWSRoom(String name);
    List<DmRoom> findAllWSRoom();
    List<DmMessage> findChatList(Long roomId);

    DmRoom findRoomById(Long roomId);
    DmMessage createMessage(MessageReq messageReq);

    void handleActions(WebSocketSession session, DmMessage chatMessage);
}
