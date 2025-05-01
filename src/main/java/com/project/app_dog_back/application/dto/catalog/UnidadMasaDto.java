package com.project.app_dog_back.application.dto.catalog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UnidadMasaDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idUnidadMasa;
    @Schema(description = "Name of the units of measurement.", example = "Kilogramo")
    private String nombre;
    @Schema(description = "General description of the unit of measurement.", example = "Unidad básica de masa en el Sistema Internacional de Unidades.")
    private String descripcion;
    @Schema(description = "Most popular acronym for the unit of measurement.", example = "kg")
    private String sigla;
    @Schema(description = "Valid or invalid registration.", example = "True o False")
    private Boolean valido;
}
