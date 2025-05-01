package com.project.app_dog_back.application.dto.catalog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovilidadDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idMovilidad;
    @Schema(description = "Name of the mobility", example = "Movilidad normal")
    private String nombre;
    @Schema(description = "General description of the mobility", example = "Movilidad normal sin problemas de movilidad.")
    private String descripcion;
    @Schema(description = "Valid or invalid registration.", example = "True o False")
    private Boolean valido;
}
