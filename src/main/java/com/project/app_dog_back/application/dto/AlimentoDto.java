package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AlimentoDto {
    private Long idAlimento;
    private String nombre;
    private String descripcion;
    private Long idTipoAlimento;
}
