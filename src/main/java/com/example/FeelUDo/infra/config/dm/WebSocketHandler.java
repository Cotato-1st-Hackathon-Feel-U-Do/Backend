package com.example.FeelUDo.infra.config.dm;

import com.example.FeelUDo.domain.directMessage.dto.MessageReq;
import com.example.FeelUDo.domain.directMessage.entity.DmMessage;
import com.example.FeelUDo.domain.directMessage.service.DmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component  // Bean 주입 할 수 있는
public class WebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    // ObjectMapper : JSON을 Java 객체로 변환할 수 있고, 반대로 Java 객체를 JSON 객체로 serialization 할 수 있음
    private final DmService dmService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload(); // payload : 전송되는 데이터
        log.info("payload {}", payload);

        // 1) web socket test
        // TextMessage textMessage = new TextMessage("Welcome chatting sever~^^");
        // session.sendMessage(textMessage);

        // 2) 실제 채팅 로직
//        WebSocketMessageDto chatMessage = objectMapper.readValue(payload, WebSocketMessageDto.class);
//        WebSocketRoomDto room = webSocketService.findRoomById(chatMessage.getRoomId());
//        room.handleActions(session, chatMessage, webSocketService);

        MessageReq messageReq = objectMapper.readValue(payload, MessageReq.class);
        // 유저 찾기
        DmMessage webSocketMessage = dmService.createMessage(messageReq);
        dmService.handleActions(session, webSocketMessage);
    }

}
