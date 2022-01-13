package com.pro.pro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ApiRequestExcept.class })
    public ResponseEntity<Object> handleApiRequestException(Throwable e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiEx apiExp = new ApiEx(e.getMessage());
        return new ResponseEntity<>(apiExp, badRequest);
    }
}
