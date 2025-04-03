package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AnimoDto {
    private Long idAnimo;
    private String nombre;
    private String descripcion;
    private Boolean valido;
}
