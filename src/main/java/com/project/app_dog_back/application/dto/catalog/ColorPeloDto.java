package com.project.app_dog_back.application.dto.catalog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ColorPeloDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idColorPelo;
    @Schema(description = "Name of hair color.", example = "Negro")
    private String nombre;
    @Schema(description = "General description of hair color.", example = "Pelo de color negro.")
    private String descripcion;
    @Schema(description = "Valid or invalid registration.", example = "True o False")
    private Boolean valido;
}
