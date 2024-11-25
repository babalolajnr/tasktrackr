
package com.tasktrackr.tasktrackr.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tasktrackr.tasktrackr.auth.exception.UserRegistrationException;
import com.tasktrackr.tasktrackr.common.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserRegistrationException.class)
    public ResponseEntity<ErrorResponse> handleUserRegistrationException(UserRegistrationException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .message(ex.getMessage())
                .field(ex.getField())
                .status(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}