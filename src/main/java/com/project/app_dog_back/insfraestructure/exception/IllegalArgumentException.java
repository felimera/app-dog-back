package com.project.app_dog_back.insfraestructure.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class IllegalArgumentException extends RuntimeException {
    private final String code;
    private final HttpStatus httpStatus;
    public IllegalArgumentException(String message, String code, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
