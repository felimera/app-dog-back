package com.project.app_dog_back.application.dto.catalog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ViaAdministracionDto {
    @Schema(description = "Unique registration identification.", example = "1")
    private Long idViaAdministracion;
    @Schema(description = "Name of the route of administration of the medication.", example = "Oral")
    private String nombre;
    @Schema(description = "General description of the route of administration.", example = "Administración por la boca, generalmente tragando el medicamento.")
    private String descripcion;
    @Schema(description = "Valid or invalid registration.", example = "True o False")
    private Boolean valido;
}
