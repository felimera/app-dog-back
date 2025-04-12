package com.project.app_dog_back.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlimentoDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idAlimento;
    @Schema(description = "Name of the food.", required = true, example = "Pro Plan HA Hydrolized")
    private String nombre;
    @Schema(description = "General description of the food.", example = "Hydrolyzed proteins are low-molecular-weight peptides resulting from the hydrolysis of intact proteins using specific proteolytic enzymes. This low molecular weight prevents binding to IgE antibodies and, consequently, the hypersensitivity reaction.")
    private String descripcion;
    @Schema(description = "Foreign identification (Tipo de alimento).", required = true, example = "1")
    private Long idTipoAlimento;
}
