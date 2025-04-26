package com.project.app_dog_back.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MedicamentoDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idMedicamento;
    @Schema(description = "Name of the medication.", example = "Dermacure")
    @NotEmpty(message = "The medication name cannot be empty.")
    @NotNull(message = "The medication name cannot be null.")
    @Size(max = 100, message = "The medication's name only has a maximum of 100 characters.")
    private String nombre;
    @Schema(description = "Description of the medication.", example = "Crema hidrantante para lesiones complejas.")
    private String descripcion;
    @Schema(description = "Pharmaceutical drug", example = "Desconocido")
    private String famaceutica;
    @Schema(description = "Identificador de llave foreanea. (Via de administración)", example = "1")
    private Long idViaAdministracion;
    @Schema(description = "Validation of whether it is a medical prescription or not. Ex: True o False", example = "true")
    @NotNull(message = "The prescription for the medication may be void.")
    private Boolean recetamedica;
    @Schema(description = "Date of registration of the medicine.", example = "2025-04-07T20:59:23.282Z")
    private LocalDateTime fechaRegistro;
}
