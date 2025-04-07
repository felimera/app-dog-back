package com.project.app_dog_back.insfraestructure.utils;

import com.project.app_dog_back.application.response.error.KeyValueError;
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
}
