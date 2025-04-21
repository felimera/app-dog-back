package com.project.app_dog_back.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlimentoDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idAlimento;
    @Schema(description = "Name of the food.", example = "Pro Plan HA Hydrolized")
    @NotEmpty(message = "The food name cannot be empty.")
    @NotNull(message = "The food name cannot be null.")
    @Size(max = 100, message = "The food's name only has a maximum of 100 characters.")
    private String nombre;
    @Schema(description = "General description of the food.", example = "Hydrolyzed proteins are low-molecular-weight peptides resulting from the hydrolysis of intact proteins using specific proteolytic enzymes. This low molecular weight prevents binding to IgE antibodies and, consequently, the hypersensitivity reaction.")
    private String descripcion;
    @Schema(description = "Foreign identification (Tipo de alimento).", example = "1")
    private Long idTipoAlimento;
}
