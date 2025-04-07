package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ViaAdministracionDto {
    private Long idViaAdministracion;
    private String nombre;
    private String descripcion;
    private Boolean valido;
}
