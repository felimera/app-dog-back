package com.project.app_dog_back.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class SalidaDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Integer idSalida;
    @Schema(description = "Date and time of check-out.", example = "2025-04-07T20:59:23.282Z")
    private LocalDateTime fechaHora;
    @Schema(description = "Validation of whether the scheduled output was performed or not. Example: True or False.", example = "false")
    private Boolean isSalidaRealizada;
    @Schema(description = "Type of exits. Example: B => Bathroom, P => Walk, BP => Bathroom and walk, V => Veterinarian", examples = {"B", "P", "BP", "V"})
    private String tipoSalida;
    @Schema(description = "Foreign key identifier. (Mascota)", example = "1")
    private Long idMascota;
}
