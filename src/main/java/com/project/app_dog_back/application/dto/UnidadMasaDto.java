package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UnidadMasaDto {
    private Long idUnidadMasa;
    private String nombre;
    private String descripcion;
    private String sigla;
    private Boolean valido;
}
