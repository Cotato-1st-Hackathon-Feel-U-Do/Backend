package com.example.FeelUDo.domain.directMessage.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum DmExceptionList {

    DENIED_ACCESS("D0001", HttpStatus.FORBIDDEN, "잘못된 접근입니다.");

    private final String CODE;
    private final HttpStatus httpStatus;
    private final String MESSAGE;

}
