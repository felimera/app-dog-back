package com.project.app_dog_back.insfraestructure.utils;

import com.project.app_dog_back.application.response.error.*;
import com.project.app_dog_back.insfraestructure.exception.BadRequestException;
import com.project.app_dog_back.insfraestructure.exception.ConflictException;
import com.project.app_dog_back.insfraestructure.exception.NotFoundException;
import com.project.app_dog_back.insfraestructure.exception.ResponseMessageException;
import org.springframework.validation.BindingResult;

import java.util.List;

public class BuildErrorUtil {
    private BuildErrorUtil() {
        throw new IllegalStateException(BuildErrorUtil.class.toString());
    }

    public static List<KeyValueError> formatMessage(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(err -> KeyValueError.builder().attributeName(err.getField()).attributeValue(err.getDefaultMessage()).build())
                .toList();
    }

    public static ErrorGeneral buildNotFoundExceptionForErrorAttribute(NotFoundException ex) {
        DetailsGeneral detailsGeneral = DetailsGeneral.builder().statusCode(ex.getHttpStatus().name()).statusCodeValue(ex.getHttpStatus().value()).build();
        return ErrorGeneral
                .builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .details(detailsGeneral)
                .build();
    }

    public static ErrorAttribute buildConflictExceptionForErrorAttribute(ConflictException ex) {
        DetailsAttribute detailsGeneral = DetailsAttribute
                .builder()
                .statusCode(ex.getHttpStatus().name())
                .statusCodeValue(ex.getHttpStatus().value())
                .data(ex.getConflictingFields())
                .build();
        return ErrorAttribute
                .builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .details(detailsGeneral)
                .build();
    }

    public static ErrorAttribute buildBadRequestExceptionForErrorAttribute(BadRequestException ex) {
        DetailsAttribute detailsGeneral = DetailsAttribute
                .builder()
                .statusCode(ex.getHttpStatus().name())
                .statusCodeValue(ex.getHttpStatus().value())
                .data(ex.getKeyValueErrors())
                .build();
        return ErrorAttribute
                .builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .details(detailsGeneral)
                .build();
    }

    public static ErrorAttribute buildResponseMessageExceptionForErrorAttribute(ResponseMessageException ex) {
        DetailsAttribute detailsGeneral = DetailsAttribute
                .builder()
                .statusCode(ex.getHttpStatus().name())
                .statusCodeValue(ex.getHttpStatus().value())
                .data(ex.getKeyValueErrors())
                .build();
        return ErrorAttribute
                .builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .details(detailsGeneral)
                .build();
    }
}
