package com.project.app_dog_back.application.dto.catalog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RazaDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idRaza;
    @Schema(description = "Name of the race", example = "Criollo")
    private String nombre;
    @Schema(description = "General description of the race.", example = "Perro mestizo, no pertenece a una raza específica")
    private String descripcion;
    @Schema(description = "Probable breed size.", example = "M")
    private String tamano;
    @Schema(description = "Valid or invalid registration.", example = "True o False")
    private Boolean valido;
}
