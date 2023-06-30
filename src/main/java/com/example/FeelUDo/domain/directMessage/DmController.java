package com.example.FeelUDo.domain.directMessage;

import com.example.FeelUDo.domain.directMessage.entity.DmRoom;
import com.example.FeelUDo.domain.directMessage.service.DmService;
import com.example.FeelUDo.global.dto.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/dm")
@RequiredArgsConstructor
@Tag(name = "DirectMessage Controller", description = "direct Message api 목록입니다.")
public class DmController {

    private final DmService dmService;

    @PostMapping("/room")
    @Operation(summary = "채팅방 생성", description = "채팅방 생성 API 입니다. ")
    public DmRoom createWSRoom(@RequestParam String name) {    // 방 이름 만들기 (방 id 생성)
        return dmService.createWSRoom(name);
    }

    @GetMapping("/all")
    public List<DmRoom> findAllWSRoom() {
        return dmService.findAllWSRoom();
    }

    @GetMapping("/test")
    @Operation(summary = "테스트", description = "테스트 용 API 입니다. ")
    public ApplicationResponse<String> test() {
        return ApplicationResponse.ok("test");
    }

}

/**

 1. 채팅룸 생성
 [POST] http://localhost:8080/web-socket


 {
 "messageType":"TALK",
 "roomId":"1",
 "senderId":"1",
 "message":"안녕 test2"
 }


 2. 채팅방 입장 - Simple websocket 실행 후 -> ws://localhost:8080/ws/web-socket연결
 {
 "type":"ENTER",
 "roomId":"1",
 "sender":"happydaddy",
 "message":""
 }

 3.
 // 메시지 발송
 {
 "type":"ENTER",
 "roomId":"1",
 "sender":"happydaddy",
 "message":""
 }

 // 메시지 수신
 {
 "type":"ENTER",
 "roomId":"1",
 "sender":"happydaddy",
 "message":"happydaddy님이 입장했습니다."
 }

 */