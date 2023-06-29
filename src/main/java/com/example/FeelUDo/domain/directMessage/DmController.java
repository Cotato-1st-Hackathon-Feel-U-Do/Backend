package com.example.FeelUDo.domain.directMessage;

import com.example.FeelUDo.global.dto.ApplicationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/dm")
@RequiredArgsConstructor
@Tag(name = "DirectMessage Controller", description = "direct Message api 목록입니다.")
public class DmController {

    @GetMapping("/test")
    @Operation(summary = "테스트", description = "테스트 용 API 입니다. ")
    public ApplicationResponse<String> test() {
        return ApplicationResponse.ok("test");
    }

}
