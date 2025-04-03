package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RazaDto {
    private Long idRaza;
    private String nombre;
    private String descripcion;
    private String tamano;
    private Boolean valido;
}
