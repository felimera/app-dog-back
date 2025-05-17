package com.project.app_dog_back.application.dto.catalog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TipoAlimentoDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idTipoAlimento;
    @Schema(description = "Name of the types of food.", example = "Alimento Seco (Croquetas)")
    private String nombre;
    @Schema(description = "General description of food types.", example = "Croquetas deshidratadas con nutrientes equilibrados.")
    private String descripcion;
    @Schema(description = "Valid or invalid registration.", example = "True o False")
    private Boolean valido;
}
