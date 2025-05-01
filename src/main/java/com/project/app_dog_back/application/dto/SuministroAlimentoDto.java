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
public class SuministroAlimentoDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idSuministro;
    @Schema(description = "Date and time of feed delivery.", example = "2025-04-07T20:59:23.282Z")
    @Pattern(regexp = Constant.REGEXP_DATE_UTC, message = "Incorrect date format. Ex: YYYY-MM-DDTHH:mm:ss.SSSZ.")
    private String fecha;
    @Schema(description = "Validate whether the food was supplied or not. Example: True or False.", example = "false")
    private Boolean isSuministroDado;
    @Schema(description = "Foreign key identifier. (Alimento)", example = "1")
    private Long idAlimento;
}
