package com.project.app_dog_back.application.dto;

import com.project.app_dog_back.insfraestructure.utils.Constant;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DosisMedicamentoDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idDosisMedicamento;
    @Schema(description = "Client's date of birth.", example = "2025-04-07T20:59:23.282Z")
    @Pattern(regexp = Constant.REGEXP_DATE_UTC, message = "Incorrect date format. Ex: YYYY-MM-DDTHH:mm:ss.SSSZ.")
    private String fecha;
    @Schema(description = "Validate whether the dose was delivered or not. Example: true or false.", example = "false")
    private Boolean dosisSuministrada;
    @Schema(description = "Identificador de llave foreanea. (Medicamento)", example = "1")
    private Long idMedicamento;
}
