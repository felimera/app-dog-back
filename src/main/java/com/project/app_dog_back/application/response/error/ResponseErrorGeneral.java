package com.project.app_dog_back.application.response.error;

import com.project.app_dog_back.application.response.Meta;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ResponseErrorGeneral {
    @Schema(description = "Meta object.", exampleClasses = Meta.class)
    private Meta meta;
    @Schema(description = "Error object.", exampleClasses = ErrorGeneral.class)
    private ErrorGeneral error;
}
