package com.project.app_dog_back.application.dto.catalog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IccDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idIcc;
    @Schema(description = "Name of Body Condition Index", example = "CONDICIÓN CORPORAL IDEAL")
    private String nombre;
    @Schema(description = "General description of Body Condition Index", example = "Costillas fácilmente palpables y visibles, sin exceso de grasa que las cubra. Cintura fácilmente visible desde arriba. Abdomen recogido al verlo de perfil.")
    private String descripcion;
    @Schema(description = "Valid or invalid registration.", example = "True o False")
    private Boolean valido;
}
