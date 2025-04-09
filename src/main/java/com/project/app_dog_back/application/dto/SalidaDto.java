package com.project.app_dog_back.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class SalidaDto {
    private Integer idSalida;
    private LocalDateTime fechaHora;
    private Boolean isSalidaRealizada;
    private String tipoSalida;
    private Long idPerro;
}
