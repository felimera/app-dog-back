package com.project.app_dog_back.application.response;

import com.project.app_dog_back.application.dto.AlimentoDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AlimentoResponse {
    @Schema(description = "Meta object.", exampleClasses = Meta.class)
    private Meta meta;
    @Schema(description = "Alimento.", exampleClasses = AlimentoDto.class)
    private Object data;
    @Schema(description = "Pagination object.", exampleClasses = Pagination.class)
    private Pagination pagination;
}
