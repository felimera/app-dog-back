package com.project.app_dog_back.application.dto.catalog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AnimoDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idAnimo;
    @Schema(description = "Name of the mood.", example = "Alegría")
    private String nombre;
    @Schema(description = "General description of the mood.", example = "Menea la cola y el trasero con entusiasmo.")
    private String descripcion;
    @Schema(description = "Valid or invalid registration.", example = "True o False")
    private Boolean valido;
}
