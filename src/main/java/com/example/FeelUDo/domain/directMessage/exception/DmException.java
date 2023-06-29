package com.example.FeelUDo.domain.directMessage.exception;

import com.example.FeelUDo.global.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public abstract class DmException extends ApplicationException {

    protected DmException(String errorCode, HttpStatus httpStatus, String message) {
        super(errorCode, httpStatus, message);
    }

}