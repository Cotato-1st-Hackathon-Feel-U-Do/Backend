package com.example.FeelUDo.domain.directMessage.exception;

import org.springframework.http.HttpStatus;

public class DeniedAccessException extends DmException{

    protected DeniedAccessException(String errorCode, HttpStatus httpStatus, String message) {
        super(DmExceptionList.DENIED_ACCESS.getCODE(),
                DmExceptionList.DENIED_ACCESS.getHttpStatus(),
                DmExceptionList.DENIED_ACCESS.getMESSAGE()
        );
    }

}
