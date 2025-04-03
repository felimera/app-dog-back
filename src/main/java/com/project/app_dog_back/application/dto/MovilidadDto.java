package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovilidadDto {
    private Long idMovilidad;
    private String nombre;
    private String descripcion;
    private Boolean valido;
}
