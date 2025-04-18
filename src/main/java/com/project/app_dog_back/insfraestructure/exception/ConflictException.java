package com.project.app_dog_back.insfraestructure.exception;

import com.project.app_dog_back.application.response.error.KeyValueError;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
public class ConflictException extends RuntimeException {
    private final String code;
    private final HttpStatus httpStatus;
    private final List<KeyValueError> conflictingFields;

    public ConflictException(String message, String code, HttpStatus httpStatus, List<KeyValueError> conflictingFields) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
        this.conflictingFields = conflictingFields;
    }
}
