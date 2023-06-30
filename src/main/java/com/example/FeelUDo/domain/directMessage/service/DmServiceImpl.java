package com.example.FeelUDo.domain.directMessage.service;

import com.example.FeelUDo.domain.directMessage.dto.MessageReq;
import com.example.FeelUDo.domain.directMessage.entity.DmMessage;
import com.example.FeelUDo.domain.directMessage.entity.DmRoom;
import com.example.FeelUDo.domain.directMessage.repository.DmMessageRepository;
import com.example.FeelUDo.domain.directMessage.repository.DmRoomRepository;
import com.example.FeelUDo.domain.user.entity.User;
import com.example.FeelUDo.domain.user.repsitory.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class DmServiceImpl implements DmService{

    private final DmRoomRepository dmRoomRepository;
    private final DmMessageRepository dmMessageRepository;
    private final UserRepository userRepository;

    private final ObjectMapper objectMapper;

    // 채팅방 생성
    @Override
    public DmRoom createWSRoom(String name){
        DmRoom dmRoom = DmRoom.builder()
                .roomName(name)
                .build();

        return dmRoomRepository.save(dmRoom);
    }

    // 채팅방 하나 조회
    @Override
    public DmRoom findRoomById(Long roomId) {
        return dmRoomRepository.findById(roomId).get();
    }

    // 채팅방 전체 조회
    @Override
    public List<DmRoom> findAllWSRoom() {
        return dmRoomRepository.findAll();
    }

    // 메시지 발송
    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    // 메시지 생성
    @Override
    public DmMessage createMessage(MessageReq messageReq){
        DmRoom room = dmRoomRepository.findById(messageReq.getRoomId()).get();
        User user = userRepository.findById(messageReq.getSenderId()).get();
        DmMessage webSocketMessage = DmMessage.builder()
                .dmRoom(room)
                .user(user)
                .message(messageReq.getMessage())
                .messageType(messageReq.getMessageType())
                .build();
        DmMessage socketMessage = dmMessageRepository.save(webSocketMessage);
        return socketMessage;
    }

    @Override
    public List<DmMessage> findChatList(Long roomId) {
        DmRoom room = dmRoomRepository.findById(roomId).get();
        return dmMessageRepository.findAllByWebSocketRoom(roomId);
    }

//////////////////////////////////////////////////////////////////

    private Set<WebSocketSession> sessions = new HashSet<>();

    @Override
    public void handleActions(WebSocketSession session,
                              DmMessage chatMessage) {
        if (chatMessage.getMessageType().equals(DmMessage.MessageType.ENTER)) {
            sessions.add(session);
//            chatMessage.setMessage(chatMessage.getSender() + "님이 입장했습니다.");
        }

        // TALK
        sendMessage(chatMessage);
    }

    public <T> void sendMessage(T message) {
        Map<String, String> arr = new HashMap<>();
        sessions.parallelStream().forEach(session -> sendMessage(session, message));
    }

}