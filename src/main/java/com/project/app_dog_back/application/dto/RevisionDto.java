package com.project.app_dog_back.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class RevisionDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Integer idRevision;
    @Schema(description = "Pet weight.", example = "30.5")
    private BigDecimal peso;
    @Schema(description = "The pet either has or doesn't have gray hair. Example: True or False.", examples = {"false", "true"})
    private Boolean canas;
    @Schema(description = "The pet either has or does not have vision problems. Example: True or False.", examples = {"false", "true"})
    private Boolean problemasVision;
    @Schema(description = "The pet either has or does not have breathing problems. Example: True or False.", examples = {"false", "true"})
    private Boolean problemasRespirar;
    @Schema(description = "Foreign key identifier. (Mascota)", example = "1")
    private Long idMascota;
    @Schema(description = "Foreign key identifier. (ICC)", example = "1")
    private Long idIcc;
    @Schema(description = "Foreign key identifier. (Movilidad)", example = "1")
    private Long idMovilidad;
    @Schema(description = "Foreign key identifier. (Animo)", example = "1")
    private Long idAnimo;
    @Schema(description = "Foreign key identifier. (Unidad de masa)", example = "1")
    private Long idUnidadMasa;
    @Schema(description = "Date of registration of the medicine.", example = "2025-04-07T20:59:23.282Z")
    private LocalDateTime fechaRegistro;
}
