package com.vsh1ft.ignitis.exception.handler;

import com.vsh1ft.ignitis.exception.UserExistsException;
import com.vsh1ft.ignitis.type.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public final class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserExistsException.class})
    public ResponseEntity<ApiError> handleUserAlreadyExistsException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiError(ex.getMessage()));
    }


}
